FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
ADD ./target/cc-eureka-server-0.0.1-SNAPSHOT.jar cc-eureka-server.jar
ENTRYPOINT ["java","-jar","/cc-eureka-server.jar"]