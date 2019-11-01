# acme-greeting-api-restful

This project represents a basic API REST with **Send**

Send and receive "Hello World! "+new Date() message

This projects stands out for:

* Provides **projects class** : Controller and Entity

## Technological Stack

* Java 8
* [Maven 3](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) 2.0.0.RELEASE
* [Spring](https://spring.io)

Dependencies with architecture projects

N/A

Third Party Dependencies

* **spring-boot-starter** [2.2.0.RELEASE] : Spring Boot + Spring Framework
* **spring-boot-starter-test** [2.2.0.RELEASE] : Spring Boot testing library
* **spring-boot-starter-web** [2.2.0.RELEASE] : Spring Boot web library
* **spring-boot-starter-jersey** [2.2.0.RELEASE] : Spring Boot JSON / REST library
* **spring-boot-devtools** [2.2.0.RELEASE] : Spring Boot Dev tools Library


## Prerequisites

Define what elements are needed to install the software

* Java 8 installed (1.5+ version required)
* Maven installed  (3+)


## Installation

Steps to follow

* Start a terminal
* To be located in the PATH of installation (the place where the project is located)
* Verify that the file "pom.xml" is available

Execute the following command

```bash
mvn clean install
```

The result will be the generation of an artifact in your maven repository


## Testing

This project has tests


## Deploy

Spring Boot

1. Execute Application.java

2. Execute the following command

```bash
mvn package && java -jar target/acme-greeting-api-restful-0.0.1-SNAPSHOT.jar
```

## Use

The service will accept HTTP GET requests at :

```bash
http://localhost:8090/greeting
```

And return JSON

```bash
{"id":1,"content":"Hello, World!"}
```

The service will accept HTTP GET requests at :

```bash
http://localhost:8090/greeting?name=Acme
```

And return JSON

```bash
{"id":1,"content":"Hello, Acme!"}
```

User the "curl"


## Actuators Endpoints

http://localhost:8091/beans
http://localhost:8091/metrics
http://localhost:8091/info


## Versioning

**Note :** [SemVer](http://semver.org/) is used for the versioning.
To see the available versions access the repository tags

## Authors

* **Víctor Madrid**
