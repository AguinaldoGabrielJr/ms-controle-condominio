FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/cc-api-gateway-zuul-0.0.1-SNAPSHOT.jar cc-api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/cc-api-gateway-zuul.jar"]