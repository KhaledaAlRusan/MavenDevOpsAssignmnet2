# Start with a base image containing Java runtime
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

# Add Maintainer Info
LABEL maintainer="khassana@my.centennialcollege.ca"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/Khaled_DevOps_Assignment2-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} Khaled_DevOps_Assignment2.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Khaled_DevOps_Assignment2.jar"]
