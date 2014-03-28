#!/usr/bin/env bash

echo 'Starting installation' | wall

# install packages
apt-get -q -y --force-yes install git openjdk-7-jre-headless openjdk-7-jdk nginx nodejs npm
sudo npm install -g bower

sudo ln -s /usr/bin/nodejs /usr/bin/node
cd /vagrant
bower install --allow-root
