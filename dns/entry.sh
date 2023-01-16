#!/bin/bash
chmod 0755 /var/cache/bind
chown -R bind:bind /var/cache/bind

chmod 0755 /etc/bind
chown -R bind:bind /etc/bind

#/usr/sbin/named -u bind -g $*
