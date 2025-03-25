#!/usr/bin/env bash

# Builds all applications and all docker images using Dockerfile and tags it based on org.opencontainers.image.version
# label in Dockerfile.

#######################################
# Script main function. Builds all applications and all docker images using Dockerfile and tags it based on
# org.opencontainers.image.version label in Dockerfile.
# Arguments:
#   None.
#######################################
function main() {
    cd ./simple-rpg-character/; sh ./build.sh; cd ..
    cd ./simple-rpg-profession/; sh ./build.sh; cd ..
    cd ./simple-rpg-user/; sh ./build.sh; cd ..
    cd ./simple-rpg-gateway/; sh ./build.sh; cd ..
    cd ./simple-rpg-ng/; sh ./build.sh; cd ..
    cd ./simple-rpg-js/; sh ./build.sh; cd ..
}

main "$@"
