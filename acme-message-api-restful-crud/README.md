# acme-greeting-api-restful-crud

This project represents a basic API REST with **User Message**

This projects stands out for:

* Provides **Configuration classes** : Classes to configure the project (scanning package, web, environment...)
* Provides **Constant Configuration classes** : Classes to configure the project
* Provides **Constant classes** : Classes to use in the project
* Provides **Generic classes** : Controller, Service, Repository, Entity, Validator, Util, DTO, ...
* Provides **Validation with Annotations** 
* Provides a **Generic exception** "MessageApiCrudException" with type (Enumerate)
* Provides **Properties Configuration File** with **Environment** (application-{environment}.yml)
* Provides **Log Configuration File** (logback.yml)
* Provides **All type of Test**
* Provides **Spring/Maven Profile Integration**
* Provides **Swagger** for document the Restful API
* Provides **Docker/Docker-Compose Profile/Environment Integration**
* Provides **Standard Surefire Test Filter with Profiles** (unit test)
* Provides **H2 Integration**
* Provides **Liquibase Integration**
* Provides **Code Coverage** with **Jacoco**
* Provides **CORS (Cross-Origin Resource Sharing ) Integration** with **Controller**
* Provices **cURL REST References**
* Provides **Dockerfile**
* Provides **Docker Compose** with : App + Mysql 5.7





## Technological Stack

* Java 8
* [Maven 3](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) 2.0.0.RELEASE
* [Spring](https://spring.io)
* [Docker](https://www.docker.com/) - Container Technology
* [Docker Compose](https://docs.docker.com/compose/) - Multi-Container Technology (Define & Run)
* [MySQL](https://www.mysql.com/) - Relational Database

Dependencies with architecture projects

N/A

Third Party Dependencies

* **spring-boot-starter** [Spring Boot Version] : Spring Boot + Spring Framework
* **spring-boot-starter-test** [Spring Boot Version] : Spring Boot testing library
* **spring-boot-starter-web** [Spring Boot Version] : Spring Boot web library
* **spring-boot-devtools** [Spring Boot Version] : Spring Boot Dev tools Library
* **spring-boot-starter-actuator** [Spring Boot Version] : Spring Boot Actuators Library
* **spring-boot-starter-data-jpa** [Spring Boot Version] : Spring Boot Persistence Library
* **spring-boot-starter-validation** [Spring Boot Version] : Spring Boot Validation Library


* **h2** [Spring Boot Version] : Database in-memory
* **liquibase-core** [Spring Boot Version] : Database changes manager
* **liquibase-maven-plugin** [3.8.1] : Plugin for to use liquibase with Maven
* **commons-lang3** [Spring Boot Version] : Java Utility Class
* **lombok** [Spring Boot Version] : Java Utility Class for : getter, setter, equals, etc.
* **mapstruct** [Spring Boot Version] : Mapper Cñass
* **mysql-connector-java** [Spring Boot Version] : Connection with Database MySQL
* **rest-assured** [Spring Boot Version] : Testing of REST services





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

Directory : src/main/resources

* Optional : Use environment variables in properties with ${VARIABLE:DEFAULT_VALUE}
* Optional : Use external properties -> going outside jar/war

```bash
java -jar target/acme-greeting-api-restful-0.0.1-SNAPSHOT.jar -Dspring.config.additional-location="C:/myapp/path/to/config/"
```



### Use Browser

The service will accept HTTP GET requests at :

```bash
http://localhost:8091/api/v1/usermessages/2
```

And return JSON

```bash
{"id":2,"description":"Test Description 2","vip":false,"creationDate":"2019-11-22T19:30:53.384+0000","deletedDate":null}
```

Use other operations




### Use "curl"


```bash
curl -i -X GET -H "Content-Type:application/json" http://localhost:8091/api/v1/usermessages
```

GET findByPk = 2

```bash
curl -i -X GET -H "Content-Type:application/json" http://localhost:8091/api/v1/usermessages/2
```

POST insert

```bash
curl -i -X POST -H "Content-Type:application/json" -d "{\"id\":null,\"description\":\"Test Description\",\"vip\":false,\"creationDate\":null,\"deletedDate\":null}"  http://localhost:8091/api/v1/usermessages
```

curl -i -X POST -H "Content-Type:application/json" -d "{\"description\":\"Test Description\",\"vip\":false}"  http://localhost:8091/api/v1/usermessages


PUT update

```bash
curl -i -X PUT -H "Content-Type:application/json" -d "{\"description\":\"Test Description\",\"vip\":false}"  http://localhost:8091/api/v1/usermessages/2
```

DELETE delete

```bash
curl -i -X DELETE -H "Content-Type:application/json" http://localhost:8091/api/v1/usermessages/4
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

Dockerize (Spring Boot + Docker) with Docker Compose

1. Execute the following command

```bash
docker-compose up
```
* Service "acme-mysql" : Run MySQL 5.7 Database
* Service "app" : Run App with Profile : Dev







## Versioning

**Note :** [SemVer](http://semver.org/) is used for the versioning.
To see the available versions access the repository tags





## Authors

* **Víctor Madrid**
