#!/usr/bin/env bash

docker run \
  --volume $(pwd)/dist:/usr/local/apache2/htdocs \
  --publish 8080:80 \
  -d \
  --rm \
  httpd
