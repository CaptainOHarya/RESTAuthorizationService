FROM openjdk:17-jdk-alpine

EXPOSE 8080

ADD target/autorizationService-0.0.1-SNAPSHOT.jar authorizationService.jar

CMD ["java", "-jar", "authorizationService.jar"]