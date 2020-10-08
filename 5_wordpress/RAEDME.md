```bash
docker run -it --name athena ubuntu
```

```bash
apt-get update && apt-get install -y vim curl net-tools iputils-ping
```


```bash
docker exec -it <container-name> /bin/bash
```


```bash
apt-cache sarch mysql
```

```bash
service --status-all
service mysql start
service mysql restart
service apache2 start
service apache2 stop
```

# Athena
```bash
mysql-client, mysql-server
```

```sql
CREATE DATABASE wordpress;

--- SHOW databases;

CREATE USER alice IDENTIFIED BY 'secret';
GRANT ALL ON wordpress.* TO 'alice'@'%';

---mysql -u alice -psecret 
```


```bash
vi /etc/mysql/mysql.conf.d/mysqld.cnf
#bind-address           = 127.0.0.1
```
# Artemis

```bash 
apt-get install apache2 php php-mysql mysql-client
mysql -u alice -psecret -h 172.17.0.2 # IP of athena
```


```bash
cd /var/www/html
curl -O https://wordpress.org/latest.tar.gz
tar xzf latest.tar.gz
rm index.html
rm latest.tar.gz
mv wordpress/* .
chown -R www-data:www-data .
```
