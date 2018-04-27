FROM ewolff/docker-java
COPY target/bff_service-0.0.1-SNAPSHOT.jar .
COPY target/config/application.properties /config/application.properties
RUN sh -c 'touch /bff_service-0.0.1-SNAPSHOT.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /bff_service-0.0.1-SNAPSHOT.jar" ]
EXPOSE 8060
