#!/usr/bin/env bash

docker run -p 8080:80 -v $(pwd):/usr/local/apache2/htdocs httpd
