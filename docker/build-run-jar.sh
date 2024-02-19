#!/bin/bash

docker buildx build --file 'Dockerfile-jar' -t cut-container-startup-time:jar .

docker run --rm cut-container-startup-time:jar
