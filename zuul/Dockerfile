FROM ewolff/docker-java
COPY target/zuul-0.0.1-SNAPSHOT.jar .
RUN sh -c 'touch /zuul-0.0.1-SNAPSHOT.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /zuul-0.0.1-SNAPSHOT.jar" ]
EXPOSE 8082
