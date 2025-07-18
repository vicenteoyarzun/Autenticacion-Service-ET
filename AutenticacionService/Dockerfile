FROM maven:3.9.6-eclipse-temurin-17 as build
COPY . /app
WORKDIR /app
RUN mvn clean pachage -DskipTes \ts

FROM eclipse-temurin:17-jdk
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]