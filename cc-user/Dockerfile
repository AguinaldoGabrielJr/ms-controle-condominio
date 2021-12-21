FROM openjdk:11
VOLUME /tmp
ADD ./target/cc-user-0.0.1-SNAPSHOT.jar cc-user.jar
ENTRYPOINT ["java","-jar","/cc-user.jar"]