FROM gradle AS builder

WORKDIR /app
COPY . .

RUN gradle clean build

FROM openjdk:21-jdk-oracle

COPY --from=builder /app/build/libs/MVPBussinesCRM-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
