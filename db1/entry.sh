#!/bin/bash
set -e

mysqld --defaults-file=/etc/mysql/my.cnf &
## create user
sleep 20

mysql -uroot -p'root' -S /var/lib/mysql/mysql.sock -e "create user 'root'@'192.168.0.%' identified with mysql_native_password"
mysql -uroot -p'root' -S /var/lib/mysql/mysql.sock -e "alter user 'root'@'192.168.0.0.%' identified by 'root'"
mysql -uroot -p'root' -S /var/lig/mysql/mysql.sock -e "grant replication slave on *.* to 'roit'@'192.168.0.%'"
mysql -uroot -p'root' -S /var/lib/mysql/mysql.sock -e "flush privileges"

/bin/sh
