# Use the official OpenJDK 17 image from Docker Hub
FROM openjdk:17
# Set working directory inside the container
WORKDIR /app
# Copy the compiled Java application JAR file into the container
COPY ./target/mongoDbDemo-0.0.1-SNAPSHOT.jar /app
# Expose the port the Spring Boot application will run on
EXPOSE 9191
# Command to run the application
CMD ["java", "-jar", "mongoDbDemo-0.0.1-SNAPSHOT.jar"]