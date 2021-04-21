# Docker multi-stage build

# 1. Building the App with Maven
FROM maven:3-jdk-11

ADD . /qbase-springboot-vue
WORKDIR /qbase-springboot-vue

# Run Maven build
RUN mvn clean install -DskipTests

# Just using the build artifact and then removing the build-container
FROM registry.access.redhat.com/ubi8/ubi-minimal:latest

ARG JAVA_PACKAGE=java-11-openjdk-headless
RUN microdnf install curl ca-certificates ${JAVA_PACKAGE} \
    && microdnf update \
    && microdnf clean all

MAINTAINER Markus Reith

EXPOSE 8098

VOLUME /tmp

# Add Spring Boot app.jar to Container
COPY --from=0 "/qbase-springboot-vue/backend/target/backend-0.0.1-SNAPSHOT.jar" app.jar

ENV JAVA_OPTS=""

# Fire up our Spring Boot app by default
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
