FROM openjdk:21-jdk-oracle
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]