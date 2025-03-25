FROM nginx:1.23.3

LABEL org.opencontainers.image.title="simple-rpg-js"
LABEL org.opencontainers.image.authors="Michał (psysiu) Wójcik"
LABEL org.opencontainers.image.source="https://git.pg.edu.pl/platformy-technologiczne/simple-rpg"
LABEL org.opencontainers.image.url="https://git.pg.edu.pl/internet-services-architectures"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Simple RPG game, character module."
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0-SNAPSHOT"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD src /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
