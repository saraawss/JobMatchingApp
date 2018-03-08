# Job Matching System
Basic matching system to find matching jobs to appropriate worker.

I used Java8, Spring boot, Angular, html, bootsrap to implement this project.

# To run the application,

mvn clean install
java -jar target\JobMatchingApp-0.0.1-SNAPSHOT.jar

#### http://localhost:8080/home

# API Documentation

### Get

#### /workers

List all the workers

#### /jobmatcher/{workerId}

Getting job list based on Driving License, Location, Certificates and Skills.
(Assuming all the workers are present)






