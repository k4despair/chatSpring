FROM openjdk:11-jre-slim
COPY target/chat.jar chat.jar
ENTRYPOINT ["java", "-jar", "chat.jar"]
EXPOSE 8080