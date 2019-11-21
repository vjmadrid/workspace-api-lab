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
* Provides **Swagger** for document the Restful API
* Provides **Standard Surefire Test Filter with Profiles** (unit & integration test)
* Provides **Dockerfile**





## Technological Stack

* Java 8
* [Maven 3](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) 2.0.0.RELEASE
* [Spring](https://spring.io)
* [Docker](https://www.docker.com/) - Container Technology

Dependencies with architecture projects

N/A

Third Party Dependencies

* **spring-boot-starter** [Spring Boot Version] : Spring Boot + Spring Framework
* **spring-boot-starter-test** [Spring Boot Version] : Spring Boot testing library
* **spring-boot-starter-web** [Spring Boot Version] : Spring Boot web library
* **spring-boot-devtools** [Spring Boot Version] : Spring Boot Dev tools Library
* **spring-boot-starter-actuator** [Spring Boot Version] : Spring Boot Actuators Library

* **springfox-swagger2** [2.4.0] : Swagger
* **springfox-swagger-ui** [2.4.0] : Swagger UI





## Prerequisites

Define what elements are needed to install the software

* Java 8 installed (1.5+ version required)
* Maven installed  (3+)
* Docker installed (19+)





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

* Deploy Method 1 : Application (Spring Boot File)
* Deploy Method 2 : Spring Boot Run
* Deploy Method 3 : Execute JAR



### Deploy Method 1 : Application (Spring Boot File)

1. Execute Application.java File

* Default 
* Configure Java "Run Configurations" IDE -> Use "Environment" with -Dspring.profiles.active=<id_profile>


### Deploy Method 2 : Spring Boot Run

1. Execute the following command

```bash
mvn spring-boot:run
```

Optional : use profile


### Deploy Method 3 : Execute JAR

Use Spring profiles with Maven Profiles -> Special Integration

* spring.profiles.active=@spring.profiles.active@
* enable resource filtering

Package the application in a single/fat JAR file (executable JAR + All dependencies + Embedded Servlet Container if its a web applications)

To run the jar file use the following command 

In this case define : "dev", "uat" and "prod"

1. Execute the following command

```bash
mvn package

or

mvn package -P<id_profile>
```

Execute

```bash
java -jar target/acme-greeting-api-restful-0.0.1-SNAPSHOT.jar
```

Use default environment -> dev or <id_profile> environment





## Use

Important : Beware of the configured port in the application-{id_profile}.yml


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

```bash
curl -X GET http://localhost:8091/greeting

or

curl -X GET http://localhost:8091/greeting?name=Acme
```





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





## Swagger

The service will accept HTTP GET requests at :

```bash
http://localhost:8091/v2/api-docs
```

And return JSON with meta inforamtion of the API


Launching swagger UI swagger-ui.html


```bash
http://localhost:8091/swagger-ui.html
```





## Dockerize

Dockerize (Spring Boot + Docker)

1. Execute the following command

```bash
mvn clean install -P<id_profile>
```

2. Verify exist target/<artifact> -> JAR

3. Execute the following command

Create a Docker image File

```bash
docker build -t acme/acme-greeting-api-restful .
```

* Copy the generated JAR

4. Verify exist image created

5. Execute the following command

Create a Docker container

```bash
docker run -p 8091:8091 -t acme/acme-greeting-api-restful
```





## Versioning

**Note :** [SemVer](http://semver.org/) is used for the versioning.
To see the available versions access the repository tags





## Authors

* **Víctor Madrid**
