# Use openjdk 17 image as base
FROM openjdk:17-alpine

# Set the working directory in the container
WORKDIR /opt

# Define environment variable for the port
ENV PORT 8080

# Expose the port 8080
EXPOSE 8080

# Copy the compiled jar file into the container
COPY target/*.jar /opt/app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
