FROM eclipse-temurin:21.0.2_13-jdk@sha256:3e0f935f60fca15b52a109fb16d63f34b4ba91ac8a6e6981bd74862ddea74c15

# install git in the container because vscode devcontainer will want to use it
RUN apt update \
 && apt install -y \
        git=1:2.34.1-1ubuntu1.10 \
        git-man=1:2.34.1-1ubuntu1.10 \
        less=590-1ubuntu0.22.04.1 \
        libbsd0:amd64=0.11.5-1 \
        libcbor0.8:amd64=0.8.0-2ubuntu1 \
        libcurl3-gnutls:amd64=7.81.0-1ubuntu1.15 \
        libedit2:amd64=3.1-20210910-1build1 \
        liberror-perl=0.17029-1 \
        libfido2-1:amd64=1.10.0-1 \
        libgdbm-compat4:amd64=1.23-1 \
        libgdbm6:amd64=1.23-1 \
        libmd0:amd64=1.0.4-1build1 \
        libperl5.34:amd64=5.34.0-3ubuntu1.3 \
        libx11-6:amd64=2:1.7.5-1ubuntu0.3 \
        libx11-data=2:1.7.5-1ubuntu0.3 \
        libxau6:amd64=1:1.0.9-1build5 \
        libxcb1:amd64=1.14-3ubuntu3 \
        libxdmcp6:amd64=1:1.1.3-0ubuntu5 \
        libxext6:amd64=2:1.3.4-1build1 \
        libxmuu1:amd64=2:1.1.3-3 \
        netbase=6.3 \
        openssh-client=1:8.9p1-3ubuntu0.6 \
        patch=2.7.6-7build2 \
        perl=5.34.0-3ubuntu1.3 \
        perl-modules-5.34=5.34.0-3ubuntu1.3 \
        xauth=1:1.1-1build2

ARG USER_NAME=vscode
ARG USER_UID=1000
ARG USER_GID=${USER_UID}

# Create the user
RUN groupadd --gid $USER_GID ${USER_NAME} \
 && useradd --uid ${USER_UID} --gid ${USER_GID} --shell /usr/bin/bash -m ${USER_NAME}
# [Optional] Add sudo support. Omit if you don't need to install software after connecting.
#            You may also `docker exec --user root -it <vscode_container_digest> bash` into your running vscode container
# && apt-get update \
# && apt-get install -y sudo \
# && echo ${USER_NAME} ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/${USER_NAME} \
# && chmod 0440 /etc/sudoers.d/${USER_NAME}

ARG MAVEN_VERSION=3.9.6
ARG MAVEN_DOWNLOAD_BASE_URL=https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries
ARG MAVEN_DOWNLOAD_URL=${MAVEN_DOWNLOAD_BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz

RUN curl -fsSL -o /tmp/apache-maven.tar.gz ${MAVEN_DOWNLOAD_URL} \
 && tar -xzf /tmp/apache-maven.tar.gz -C /opt \
 && rm -f /tmp/apache-maven.tar.gz

ENV PATH /opt/apache-maven-${MAVEN_VERSION}/bin:${PATH}
ENV MAVEN_HOME /opt/apache-maven-${MAVEN_VERSION}
# FIXME: findout what would be the best place for a home dir in a containerized rootless environement but without a user folder (because user folder may vary: UID, name etc...)
# ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

RUN curl -fsSL https://deb.nodesource.com/setup_21.x | bash - \
 && apt-get install -y nodejs
RUN npm install -g diff-so-fancy

USER ${USER_NAME}
