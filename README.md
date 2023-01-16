# Winter-Project
동계 프로젝트

## 1. 기본 설정
```
script.sh
```

## 2. docker 실행
```
docker-compose up --build -d

docker-exec -it web /bin/bash
docker-exec -it dns /bin/bash
```


## 3. 확인(dns)  
```
nslookup sw.ghkdtlwns987.com  
nslookup ghkdtlwns987,.com 
```

## 4. mysql
#### db1
```
mysql -uroot -h 127.0.0.1 -p'root'  
```
  
#### db2  
```
mysql -uroot -p 127.0.0.1 -p'root'
```

## 5. Load Banancing
### Mysql Replication
```
show slave status\G
```
