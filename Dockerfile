FROM openjdk:11-jdk
MAINTAINER Eduardo
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]