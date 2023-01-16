#!/bin/sh
docker network create --subnet 192.168.0.0/16 --gateway 192.168.0.1 winter-project_mynet
