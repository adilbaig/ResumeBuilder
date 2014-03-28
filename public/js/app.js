requirejs.config({
    "baseUrl":"/",
    "urlArgs":"bust=" + (new Date()).getTime(),
    "paths": {
        "bootstrap": [
            "//ajax.aspnetcdn.com/ajax/bootstrap/3.1.1/bootstrap.min",
            "vendor/bootstrap/dist/js/bootstrap.min"
        ],
        "jquery": [
            "//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min",
            "//ajax.aspnetcdn.com/ajax/jQuery/jquery-1.10.2.min",
            "vendor/jquery/dist/jquery.min"
        ],
        "google-analytics": "//www.google-analytics.com/analytics",
        "my-analytics": "js/analytics/google",
        "window": "js/lib/window",
    },
    "config": {
        "my-analytics": {
            "google": {
                "accountNo":"UA-44980968-1",
                "domainName":"waseem-ahmed.info"
            }
        }
    },
    "shim": {
        "bootstrap": ["jquery"],
        "my-analytics": ["google-analytics"],
        "google-analytics": {"exports": "ga"}
    }
});

requirejs(["bootstrap","my-analytics"], function($) {
    console.log('Ready!');
});
