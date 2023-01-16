#!/bin/bash

echo "ghkdtlwns987" > /etc/hostname

mkdir -p /var/cache/bind/key
cd /var/cache/bind/key

chown -R root:root /var/cache/bind/
chmod 666 -R /var/cache/bind
chmod 666 -R /var/cache/bind/key/

result1=`dnssec-keygen -a NSEC3RSASHA1 -b 1024 -n ZONE ghkdtlwns987.com`
result2=`dnssec-keygen -a NSEC3RSASHA1 -b 1024 -n ZONE -f KSK ghkdtlwns987.com`

echo "\$INCLUDE /var/cache/bind/key/${result1}.key" >> "/var/cache/bind/ghkdtlwns987.com.zone"
echo "\$INCLUDE /var/cache/bind/key/${result2}.key" >> "/var/cahce/bind/ghkdtlwns987.com.zone"
