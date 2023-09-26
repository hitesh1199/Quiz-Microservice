# Spring Boot "Microservice" Quiz Project

This is a sample Java / Maven / Spring Boot (version 1.5.6) application 


## About the Service

The service is a Quiz creation REST service. It uses an Postgress database to store the data.


Here is what this little application demonstrates: 

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
 Exception mapping from application exceptions to the right HTTP response with exception details in the body
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations. 
* Automatic CRUD functionality against the data source using Spring *Repository* pattern

Here are some endpoints you can call:

### Get information about system health, configurations, etc.

```
http://localhost:8080/quiz/create
http://localhost:8080/quiz/get/{id}
http://localhost:8080/quiz/submit/{id}
```



# Questions and Comments: hahuja1199@gmail.com
