# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/naming-server-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]