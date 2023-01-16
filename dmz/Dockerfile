FROM ubuntu:20.04
MAINTAINER ghkdtlwns987
WORKDIR /root
ENV LC_CTYPE C.UTF-8
ARG DEBIAN_FRONTEND=noninteractive

RUN apt update -y
RUN apt install dnsutils net-tools iputils-ping vim -y

ADD etc/resolv.conf /resolv.conf

EXPOSE 80

CMD /bin/bash
