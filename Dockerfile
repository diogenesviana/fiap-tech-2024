FROM openjdk:21

WORKDIR /app

COPY target/fast-food-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "fast-food-0.0.1-SNAPSHOT.jar"]