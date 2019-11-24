# acme-greeting-web-restful-crud

This project represents a Sprinb Boot VueJS - Spring MVC (Controller) with **User Message**

This projects stands out for:

* Provides **Configuration classes** : Classes to configure the project (scanning package, web, environment...)
* Provides **Constant Configuration classes** : Classes to configure the project
* Provides **Constant classes** : Classes to use in the project
* Provides **Generic classes** : Controller
* Provides **Properties Configuration File** with **Environment** (application-{environment}.yml)
* Provides **Log Configuration File** (logback.yml)
* Provides **Spring/Maven Profile Integration**
* Provides **Mapper Entity - DTO**
* Provides **Docker/Docker-Compose Profile/Environment Integration**
* Provides **Standard Surefire Test Filter with Profiles** (unit test)
* Provides **Code Coverage** with **Jacoco**





## Technological Stack

* Java 8
* [Maven 3](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) 2.0.0.RELEASE
* [Spring](https://spring.io)
* [Docker](https://www.docker.com/) - Container Technology
* [VueJS] (https://vuejs.org/) - JavaScript Framework

Dependencies with architecture projects

N/A

Third Party Dependencies

* **spring-boot-starter** [Spring Boot Version] : Spring Boot + Spring Framework
* **spring-boot-starter-test** [Spring Boot Version] : Spring Boot testing library
* **spring-boot-starter-web** [Spring Boot Version] : Spring Boot web library
* **spring-boot-devtools** [Spring Boot Version] : Spring Boot Dev tools Library
* **spring-boot-starter-actuator** [Spring Boot Version] : Spring Boot Actuators Library
* **spring-boot-starter-freemarker** [Spring Boot Version] : Spring Boot Template

* **liquibase-maven-plugin** [3.8.1] : xxx
* **commons-lang3** [Spring Boot Version] : xxx
* **lombok** [Spring Boot Version] : xxx
* **mapstruct** [Spring Boot Version] : xxx
* **mysql-connector-java** [Spring Boot Version] : xxx
* **rest-assured** [Spring Boot Version] : xxx





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
java -jar target/acme-greeting-web-restful-0.0.1-SNAPSHOT.jar
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

N/A
## Use Actuators Endpoints

Important : Beware of the configured port

The actuators endpoints are configured in the application.yml
* Port : 8090
* Based-path : /manage

Example : http://localhost:8090/manage/info

The service will accept HTTP GET requests at :

```bash
http://localhost:8090/manage/<endpoint>
```





## Swagger

N/A





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
docker build -t acme/acme-greeting-web-restful .
```

* Copy the generated JAR

4. Verify exist image created

5. Execute the following command

Create a Docker container

```bash
docker run -p 8090:8090 -t acme/acme-greeting-web-restful
```





## Versioning

**Note :** [SemVer](http://semver.org/) is used for the versioning.
To see the available versions access the repository tags





## Authors

* **Víctor Madrid**
