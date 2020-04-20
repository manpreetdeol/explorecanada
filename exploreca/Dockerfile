FROM java:8
WORKDIR /
ADD target/exploreca-0.0.1-SNAPSHOT.jar //
EXPOSE 8080
ENTRYPOINT [ "java", "-Dspring.profiles.active=mysql", "-jar", "/exploreca-0.0.1-SNAPSHOT.jar"]
