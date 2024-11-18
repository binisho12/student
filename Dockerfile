
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/demo_web-0.0.1-SNAPSHOT.jar demo_web-0.0.1-SNAPSHOT.jar
EXPOSE 8989
ENTRYPOINT ["java", "-jar", "demo_web-0.0.1-SNAPSHOT.jar"]
