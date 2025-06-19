FROM maven:3.9.5-eclipse-temurin AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean install -DskipTests

FROM openjdk:20

WORKDIR /app

COPY --from=build /app/target/service-registry.jar .

EXPOSE 8761 

CMD [ "java", "-jar", "service-registry.jar" ]

