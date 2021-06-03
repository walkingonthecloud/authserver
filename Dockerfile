FROM openjdk:8-jre-alpine3.9
WORKDIR /
EXPOSE 8080
COPY target/authserver-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","app.jar"]
