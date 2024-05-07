FROM openjdk:21

WORKDIR /app

COPY target/my-java-app.jar /app

CMD ["java", "-jar", "my-java-app.jar"]