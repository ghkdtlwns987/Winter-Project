#Dockerfile
FROM jenkins/jenkins:lts
USER root

RUN apt-get update && apt-get install -y lsb-release
RUN apt install dnsutils net-tools iputils-ping vim -y
RUN apt install apt-utils -y
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
	https://download.docker.com/linux/debian/gpg
RUN echo "deb [arch=$(dpkg --print-architecture) \
	signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
	https://download.docker.com/linux/debian \
	$(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list

RUN apt-get update && apt-get install -y docker-ce-cli

RUN mkdir -p /root/.ssh/id_rsa
RUN chmod -R 744 /root/.ssh

USER jenkins
RUN jenkins-plugin-cli --plugins "blueocean:1.25.2 docker-workflow:1.27"
