#!/bin/bash

echo "ghkdtlwns987" > /etc/hostname

mkdir -p /var/cache/bind/key
cd /var/cache/bind/key

chown -R root:root /var/cache/bind/
chmod 666 -R /var/cache/bind
chmod 666 -R /var/cache/bind/key/

cd /var/cache/bind/key
result1=`dnssec-keygen -a NSEC3RSASHA1 -b 1024 -n ZONE ghkdtlwns987.com`
result2=`dnssec-keygen -a NSEC3RSASHA1 -b 1024 -n ZONE -f KSK ghkdtlwns987.com`

echo "\$INCLUDE /var/cache/bind/key/${result1}.key" >> "/var/cache/bind/ghkdtlwns987.com.zone"
echo "\$INCLUDE /var/cache/bind/key/${result2}.key" >> "/var/cahce/bind/ghkdtlwns987.com.zone"

cd /var/cache/bind
dnssec-signzone -S -K /var/cache/bind/key/ -o ghkdtlwns987.com -S ghkdtlwns987.com.zone

cp /var/cache/bind/ghkdtlwns987.com.zone.signed /etc/bind/named.conf.local
