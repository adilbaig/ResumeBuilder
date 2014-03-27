#!/usr/bin/env bash

echo 'Updating apt-get registry and clean up ...' | wall

apt-get update
apt-get upgrade
apt-get autoremove

echo 'Starting installation ...' | wall

cd /vagrant

docs/scripts/deps.sh

echo 'Re-mapping Public directory ...' | wall

rm -rf /var/www
ln -fs /vagrant/public /var/www
sudo /etc/init.d/nginx restart
