#
# Build stage
#
FROM maven:latest AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean compile package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/chat.jar chat.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "chat.jar"]