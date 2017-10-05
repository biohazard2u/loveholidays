####################################
## loveholidays Coding Exercise  ###
####################################
The Problem
	There is a website called Programmable Web ( http://www.programmableweb.com ) that lists a set of Public
	APIs that are free to use. Given this resource, find a suitable 3rd party address API and create a small
	Spring Boot application to retrieve the street address (and name if available) for the following UK
	postcodes:
		● W6 0LG
		● SW1A 2AA
		● BT48 6DQ
Problem Constraints
	● It must be written using Java 8 and use Spring Boot and Gradle .
	● You can use any 3rd party libraries to help achieve your task.
	● You can use any IDE (or text editor) of your choice ( spaces , not tabs please !)
	● Please use JSON as the data format.



################################
### Running the application  ###
################################
This is an Springboot application - REST microservice.
 - To build the application do: mvn clean install
 - To run the application do: mvn spring-boot:run
 - The app has been set with swagger, to try the app just go to: http://localhost:8080/swagger-ui.html
 	JSON examples can be seen in swagger.
 - Library used is: https://alpha.openaddressesuk.org/addresses.json?postcode=W60LG
 	
 TODOs:	 (Due to not enough time)
 - I also wanted to add some emoticons in the tests :) , I'm using JUnit5 after all.
 
 
 
################
### Example  ###
################
 
REQUEST:
	
RESPONSE:
