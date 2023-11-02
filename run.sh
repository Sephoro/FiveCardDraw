#!/bin/bash

# JAR file name
JAR_FILE="poker-0.0.1-SNAPSHOT.jar"

# Check if the JAR file already exists
if [ -f "target/$JAR_FILE" ]; then
    # Run the Spring Boot application
    java -jar target/$JAR_FILE
else
    
    # Clean and build the Spring Boot application using Maven
    
    echo "First time run..."
   

    
    if [ $# -gt 0 ] && [ "$1" == "-show-logs" ]; then

        # Clean Install and show longs

        echo "Installing dependecies, this may take a while. All logs will be shown"

        ./mvnw clean install
    else

        # Clean Install Silently
        echo "Installing silently dependecies, this may take a while. to show logs use the -show-logs option"

        ./mvnw clean install > /dev/null 2>&1

        clear
    fi
 

    # Check if the Maven build was successful
    if [ $? -eq 0 ]; then

        # Run the Spring Boot application
        java -jar target/$JAR_FILE

    else
        echo "Maven build failed. Please fix the issues before running the application."
        exit 1
    fi
fi