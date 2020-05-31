FROM openjdk:8-jdk-alpine

COPY target/*.jar /opt/
#ENTRYPOINT ["java","-jar","/app.jar"]
ARG MYAPP_IMAGE=counterapp:latest
ENTRYPOINT java $JAVA_OPTS -jar /opt/counterapp-0.0.1-SNAPSHOT.jar
