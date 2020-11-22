#the base image to be used
FROM java:8 

#specify variables to be reused
ARG JAR_FILE=target/containerization-demo-1.0.1.jar
				
#specific folder to be created in container
VOLUME /service_resources 	

#files to be copied to container
ADD ${JAR_FILE} containerization-demo.jar

#the port of the container to be exposed
EXPOSE 8123 	

#Set variables to environment
ENV welcome.message="from docker config"

#command and parameters that will be executed when a container runs
ENTRYPOINT ["java","-Dcustom.varaiable=testValue", "-jar","/containerization-demo.jar"]