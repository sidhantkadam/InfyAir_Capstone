# Use the official OpenJDK 23 image from Docker Hub
FROM openjdk:23
# Set working directory inside the container
WORKDIR /app
# Copy the compiled Java application JAR file into the container
COPY ./target/InfyAir.jar /app
# Expose the port the Spring Boot application will run on
EXPOSE 8080
# Command to run the application
CMD ["java", "-jar", "InfyAir.jar"]