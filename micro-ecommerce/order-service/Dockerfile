FROM maven:3.9.5-eclipse-temurin AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean install -DskipTests

FROM openjdk:20

WORKDIR /app

COPY --from=build /app/target/order-service.jar .

EXPOSE 8081

CMD [ "java", "-jar", "order-service.jar" ]

