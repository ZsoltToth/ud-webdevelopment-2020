#!/usr/bin/env bash
docker run \
  -it \
  -v $(pwd):/home/node \
  node \
  /bin/bash
