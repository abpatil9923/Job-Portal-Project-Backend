# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/authentication-service-0.0.1-SNAPSHOT.jar app.jar

# Install curl
RUN apt update && apt install -y curl

# Expose the application port
EXPOSE 9100

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]