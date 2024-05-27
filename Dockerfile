FROM openjdk:21

WORKDIR /app

COPY . .

RUN mvn package

CMD ["java", "-jar", "fast-food-0.0.1-SNAPSHOT.jar"]
