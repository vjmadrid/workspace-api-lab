# acme-greeting-api-restful

This project represents a basic API REST with **Hello World (Greeting)**

Invoke : localhost:<port>/greeting

And you receive : {"id":1,"content":"Hello, World!","responseTime":"???"}

This projects stands out for:

* Provides **Configuration classes** : Classes to configure the project (scanning package,...)
* Provides **Constant classes** : Classes to configure the project
* Provides **Basic classes** : Controller and Entity
* Provides **Properties Configuration File** with **Environment** (application-{environment}.yml)
* Provides **Log Configuration File** (logback.yml)
* Provides **Spring/Maven Profile Integration**



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

The result will be the generation of an artifact in your Maven repository (local)

Generate : JAR File



## Testing

This project has tests : Unit + Integration

Execute with IDE or Maven



## Deploy

Spring Boot

### Deploy Method 1

1. Execute Application.java File

or 

1. Execute the following command

```bash
mvn spring-boot:run
```


### Deploy Method 2

1. Execute the following command

```bash
mvn package 
```

Package the application in a single/fat JAR file (executable JAR + All dependencies + Embedded Servlet Container if its a web applications)

To run the jar file use the following command 

```bash
java -jar target/acme-greeting-api-restful-0.0.1-SNAPSHOT.jar
```

Use default environment -> dev


### Deploy Method 3 : Environment

1. Execute the following command

Use Spring profiles with Maven Profiles -> Special Integration

* spring.profiles.active=@spring.profiles.active@
* enable resource filtering


In this case define : "dev", "uat" and "prod"

```bash
mvn package -Pprod
```
Package the application in a single/fat JAR file (executable JAR + All dependencies + Embedded Servlet Container if its a web applications)

To run the jar file use the following command 

```bash
java -jar target/acme-greeting-api-restful-0.0.1-SNAPSHOT.jar
```

Use default environment




## Use

Important : Beware of the configured port


### Use Browser

The service will accept HTTP GET requests at :

```bash
http://localhost:8091/greeting
```

And return JSON

```bash
{"id":1,"content":"Hello, World!","responseTime":"???"}
```

The service will accept HTTP GET requests at :

```bash
http://localhost:8091/greeting?name=Acme
```

And return JSON

```bash
{"id":1,"content":"Hello, Acme!","responseTime":"???"}
```

### Use "curl"

Use the "curl"




## Use Actuators Endpoints

Important : Beware of the configured port

The actuators endpoints are configured in the application.yml
* Port : 8091
* Based-path : /manage

Example : http://localhost:8091/manage/info

The service will accept HTTP GET requests at :

```bash
http://localhost:8091/manage/<endpoint>
```



## Versioning

**Note :** [SemVer](http://semver.org/) is used for the versioning.
To see the available versions access the repository tags



## Authors

* **Víctor Madrid**
