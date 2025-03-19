# use an official OpenJDK runtime as a base image
FROM openjdk:21-jdk-slim

# set a working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/LabAssignment01Noulis-0.0.1-SNAPSHOT.jar /app/my-java-app.jar

EXPOSE 8080

# Command to run the app
CMD ["java", "-jar", "/app/my-java-app.jar"]