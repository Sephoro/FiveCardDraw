#!/bin/bash

# JAR file name

JAR_FILE="poker-0.0.1-SNAPSHOT.jar"

# Clean and build the Spring Boot application using Maven

./mvnw clean install

# Run the jar file

java -jar target/$JAR_FILE