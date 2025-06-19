FROM maven:3.9.5-eclipse-temurin AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean install -DskipTests

FROM openjdk:20

WORKDIR /app

COPY --from=build /app/target/product-catalog.jar .

EXPOSE 8082 

CMD [ "java", "-jar", "product-catalog.jar" ]

