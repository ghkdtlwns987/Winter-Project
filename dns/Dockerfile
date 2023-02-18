FROM ubuntu:20.04
MAINTAINER ghkdtlwns987
WORKDIR /root
ENV LC_CTYPE C.UTF-8
ARG DEBIAN_FRONTEND=noninteractive

RUN apt update -y
RUN apt install bind9 bind9utils bind9-doc dnsutils iputils-ping vim -y
RUN apt install net-tools 

RUN mkdir -p /var/cache/bind/key
WORKDIR /etc/bind

# COPY start.sh /start.sh
# RUN chmod +x /start.sh
# RUN sh /start.sh

COPY entry.sh /entry.sh
RUN chmod +x /entry.sh
RUN sh /entry.sh

CMD /usr/sbin/named -u bind && /bin/bash
