# Build app with maven
FROM maven:3.6-jdk-8 AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

# Expose artifact for deployment
FROM openjdk:8-jdk-alpine
COPY --from=build /app/target/true-to-size-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/usr/local/lib/app.jar"]