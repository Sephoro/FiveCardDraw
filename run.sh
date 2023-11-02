#!/bin/bash

# JAR file name

JAR_FILE="poker-0.0.1-SNAPSHOT.jar"

# Clean and build the Spring Boot application using Maven

./mvnw clean install

# Check if the Maven build was successful
if [ $? -eq 0 ]; then

    # Clear The Screen from all the logs
    # Detect the operating system
    if [ "$(uname)" == "Darwin" ]; then
        # Mac OS X
        clear
    elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
        # Linux
        clear
    elif [ "$(expr substr $(uname -s) 1 10)" == "MINGW32_NT" ] || [ "$(expr substr $(uname -s) 1 10)" == "MSYS_NT-10" ]; then
        # Windows with MSYS2 (Git Bash, Cygwin, etc.)
        cls
    fi

    # Run the Spring Boot application
    java -jar target/$JAR_FILE
else
    echo "Maven build failed. Please fix the issues before running the application."
fi