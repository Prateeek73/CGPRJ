FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=build/libs/patientms-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8100
ENTRYPOINT ["java","-jar","/app.jar"]