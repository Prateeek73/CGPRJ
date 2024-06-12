FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=build/libs/hospitalms-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} hospitalms.jar
EXPOSE 8100
ENTRYPOINT ["java","-jar","/hospitalms.jar"]

# FROM openjdk:17
# VOLUME /tmp
# ARG build/libs/hospitalms-0.0.1-SNAPSHOT.jar

# # environment variable with default value
# ENV SPRING_PROFILE=dev
# COPY ${JAR_FILE} /hospitalms.jar
# EXPOSE 8100
# #run with environment variable
# # ENTRYPOINT java -Dspring.profiles.active=$SPRING_PROFILE -jar hospitalms.jar
# ENTRYPOINT java -jar hospitalms.jar