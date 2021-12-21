FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/cc-config-server-0.0.1-SNAPSHOT.jar cc-config-server.jar
ENTRYPOINT ["java","-jar","/cc-config-server.jar"]