FROM openjdk:8-jdk-alpine
WORKDIR /src/uygulamam
COPY /target/currencytracker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8089
CMD ["java","-jar","app.jar"]