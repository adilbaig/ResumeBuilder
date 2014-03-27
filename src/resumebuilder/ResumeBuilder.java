/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resumebuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author adil
 */
public class ResumeBuilder {

    /**
     * @param args the command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
                
        if(args.length < 1) {
            throw new Exception("Usage : PORT");
        }
        
        System.out.println("Listening on " + args[0]);
        
        ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
            
        while (true) {

            Map<String, String> params = new HashMap<>();
            
            Socket client = ss.accept();
            
            System.out.println("Connection receieved");
            
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            // Build a POST parser
            String input = in.readLine();
            System.out.println(input);
            
            if(input.charAt(0) == '?')
                input = input.substring(1);
            
            String[] str = input.split("&");
            for (String paramString : str) {
                int idx = paramString.indexOf("=");
                if(idx > 0) {
                    params.put(URLDecoder.decode(paramString.substring(0, idx), "UTF-8"), URLDecoder.decode(paramString.substring(idx + 1), "UTF-8"));
                }
            }
            
            out.write(params.toString());
            out.flush();
            
            client.close();
            
            System.out.println("Connection closed");
        }
    }
    
}
