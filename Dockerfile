# Use an official maven/Java parent image
FROM maven:3.5.2-jdk-8-alpine as build

# Set the working directory in the image to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# package our application code
RUN mvn clean package

# Use Tomcat image to deploy
FROM tomcat:8.5.34-jre8-alpine

MAINTAINER Khaled

# Delete default apps in Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR file
COPY --from=build /app/target/Khaled_DevOps_Assignment2.war /usr/local/tomcat/webapps/ROOT.war

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
w