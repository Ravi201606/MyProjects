# Theatre ticket control app


## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- Please make sure mongodb is up and running on your machine.
- Please make sure port 8080 available and not in use already. You can change it in application configuration file if needed.

```shell
server.port=8090
```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.myapp.theatreticket.TheatreTicketApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

You can also run the below command from dist directory to execute the application

```shell
java -jar theatre-ticket-1.0.jar
```

## Swagger URL

Please find the below Swagger URL for documentation

```shell
http://localhost:8080/theatre/api/swagger-ui.html
```

## POSTMAN Collection

Please find the 'Theatre Ticket.postman_collection.json' for your reference.