FROM openjdk:11
ADD target/chat.jar chat.jar
ENTRYPOINT ["java", "-jar", "chat.jar"]
