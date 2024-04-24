FROM openjdk:17-jdk-slim-buster
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=mint-training-app.jar
ADD ${JAR_FILE} mint-training-app.jar
ENTRYPOINT ["java","-jar","/mint-training-app.jar"]