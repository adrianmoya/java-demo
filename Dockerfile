FROM eclipse-temurin:21-jre-ubi9-minimal
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY build/libs/demo-0.0.1-SNAPSHOT.jar javademo.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar javademo.jar
