FROM openjdk:11
VOLUME /tmp
ADD ./target/cc-resident-0.0.1-SNAPSHOT.jar cc-resident.jar
ENTRYPOINT ["java","-jar","/cc-resident.jar"]