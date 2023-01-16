FROM ubuntu:20.04
MAINTAINER ghkdtlwns987
WORKDIR /root
ENV LC_CTYPE C.UTF-8
ARG DEBIAN_FRONTEND=noninteractive

RUN apt update -y
RUN apt install dnsutils net-tools iputils-ping vim -y
RUN apt install apache2 -y
RUN apt install openssh-server -y

ADD etc/resolv.conf /resolv.conf
ADD var/index.html /index.html
ADD etc/sshd_config /sshd_config
EXPOSE 80

WORKDIR /var/www/html

CMD cp /resolv.conf /etc/resolv.conf && cp /index.html /var/www/html/index.html && cp /sshd_config /etc/ssh/sshd_config && service apache2 start && service ssh start && /bin/bash
