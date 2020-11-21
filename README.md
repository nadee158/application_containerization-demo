# application_containerization-demo
This application is to demonstrate containerization of a spring boot application using docker

build application
===================

    # clean install application using maven
    mvn clean install
    
run application
===================

    # run application's executable Fat Jar using java
    java -jar containerization-demo-1.0.0.jar
    
test application
===================
To check if the application has started properly check below endpoints

    http://localhost:8080/
    
Rest API:-
	
	http://localhost:8080/greeting
    