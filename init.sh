#!/bin/bash

_GRAALVM="22.3.3.r17-grl"

dnf upgrade -y --refresh
dnf install -y \
	maven \
	unzip \
	zip \
	gcc \
	zlib-devel

# https://sdkman.io/
curl -s "https://get.sdkman.io" | bash

source "/root/.sdkman/bin/sdkman-init.sh"
sdk install java "${_GRAALVM}"
sdk use java "${_GRAALVM}"
gu install native-image
