#!/bin/bash

docker buildx build --file 'Dockerfile-native-image' -t cut-container-startup-time:native-image .

docker run --rm cut-container-startup-time:native-image
