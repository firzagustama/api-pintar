# build phase
#FROM maven:3.8.1-jdk-11-openj9
#COPY /api-pintar-application/src /api-pintar-application/src
#COPY /api-pintar-application/pom.xml /api-pintar-application/pom.xml
#COPY /api-pintar-facade/src /api-pintar-facade/src
#COPY /api-pintar-facade/pom.xml /api-pintar-facade/pom.xml
#COPY /api-pintar-service/src /api-pintar-service/src
#COPY /api-pintar-service/pom.xml /api-pintar-service/pom.xml
#COPY pom.xml pom.xml
#RUN mvn -f pom.xml clean install -DskipTests

# package phase
FROM openjdk:19-jdk-alpine
ARG JAR_FILE=api-pintar-application/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]