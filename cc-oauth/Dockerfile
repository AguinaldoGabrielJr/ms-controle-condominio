FROM openjdk:11
VOLUME /tmp
ADD ./target/cc-oauth-0.0.1-SNAPSHOT.jar cc-oauth.jar
ENTRYPOINT ["java","-jar","/cc-oauth.jar"]
#