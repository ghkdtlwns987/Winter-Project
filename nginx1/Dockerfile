FROM nginx

RUN apt-get update -y
RUN apt-get install vim -y

#COPY ./conf.d/default.conf /etc/nginx/conf.d/default.conf
COPY ./html/ /usr/share/nginx/html
