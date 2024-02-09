#Start with defining base Image containing JAVA Runtime
FROM openjdk:17-jdk-alpine

# Download and install JDK (adapt for your desired version)

MAINTAINER customer

#Add application Jar to the Image
COPY target/Customer-0.0.1-SNAPSHOT.jar Customer-0.0.1-SNAPSHOT.jar


#MONGODB PORT
#EXPOSE 27017

#SPRING APPLICATION PORT
EXPOSE 8080

#Execute Application
ENTRYPOINT ["java","-jar","Customer-0.0.1-SNAPSHOT.jar"]