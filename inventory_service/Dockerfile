FROM ewolff/docker-java
COPY target/inventory_service-0.0.1-SNAPSHOT.jar .
COPY target/config/META-INF/persistence.xml /config/META-INF/persistence.xml
COPY target/config/application.properties /config/application.properties
RUN sh -c 'touch /inventory_service-0.0.1-SNAPSHOT.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /inventory_service-0.0.1-SNAPSHOT.jar" ]
EXPOSE 8020
