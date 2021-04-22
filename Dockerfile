FROM openjdk:8
ADD target/office-hub-server.war office-hub-server.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "office-hub-server.war"]
