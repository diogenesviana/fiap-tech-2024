FROM maven:3.9.6-sapmachine-21 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:21
COPY --from=build /home/app/target/fast-food-0.0.1-SNAPSHOT.jar /usr/local/lib/fast-food.jar
CMD ["java", "-jar", "/usr/local/lib/fast-food.jar"]
