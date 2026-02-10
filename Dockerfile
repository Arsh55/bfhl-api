
FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app


COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the Spring Boot jar
CMD ["java", "-jar", "target/bfhl-0.0.1-SNAPSHOT.jar"]
