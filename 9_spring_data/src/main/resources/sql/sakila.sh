#!/usr/bin/env bash

CONTAINER_NAME=sakila
ROOT_PASSWORD=secret
MYSQL_HOME=/home/mysql


if [[ $# -ne 1 ]]
then
    printf "sakila.sh start|stop|cli|bash\n"
    exit 1
fi

if [ $1 == "bash" ]
then
    docker exec -it $CONTAINER_NAME bash
    exit 0
fi

if [ $1 == "cli" ]
then
    docker exec -it $CONTAINER_NAME mysql -u root -p$ROOT_PASSWORD
    exit 0
fi


if [ $1 == "stop" ]
then
    docker stop $CONTAINER_NAME
    docker container rm $CONTAINER_NAME
    exit 0
fi

if [ $1 == "start" ]
then

    docker run \
     --detach \
     --name $CONTAINER_NAME \
     --publish 3306:3306 \
     --volume $(pwd):$MYSQL_HOME \
     --env MYSQL_ROOT_PASSWORD=$ROOT_PASSWORD \
     mysql:8

    sleep 30s
    # TODO: Wait until MySQL started in the container or number of connection refused.
    # try=0
    # until [[ $(docker exec $CONTAINER_NAME mysql -u root -p$ROOT_PASSWORD -e ";") ]];
    # do
    #     printf "Connection Refused #%d time\n" $try
    #     try=$(expr $try + 1)
    #     sleep 1s
    # done
    docker exec $CONTAINER_NAME sh -c "mysql -u root -p$ROOT_PASSWORD < $MYSQL_HOME/sakila-schema.sql 2>/dev/null"
    docker exec $CONTAINER_NAME sh -c "mysql -u root -p$ROOT_PASSWORD < $MYSQL_HOME/sakila-data.sql 2>/dev/null"

    exit 0
fi

