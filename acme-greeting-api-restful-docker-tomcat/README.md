# acme-greeting-api-restful-docker-tomcat

This project represents a basic API REST with **Hello World (Greeting)** with **Docker / Tomcat**

Invoke : localhost:<port>/greeting

And you receive : {"id":1,"content":"Hello, World!","responseTime":"???"}

This projects stands out for:

* Provides **Configuration classes** : Classes to configure the project (scanning package,...)
* Provides **Constant classes** : Classes to configure the project
* Provides **Basic classes** : Controller and Entity
* Provides **Properties Configuration File** (application.yml)
* Provides **Log Configuration File** (logback.yml)
* Provides **Dockerfile**



## Technological Stack

* Java 8
* [Maven 3](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) 2.0.0.RELEASE
* [Spring](https://spring.io)
* [Docker](https://www.docker.com/) - Container Technology
* [Tomcat 8.5](http://tomcat.apache.org) : Servlet Container

Dependencies with architecture projects

N/A

Third Party Dependencies

* **spring-boot-starter** [2.2.0.RELEASE] : Spring Boot + Spring Framework
* **spring-boot-starter-test** [2.2.0.RELEASE] : Spring Boot testing library
* **spring-boot-starter-web** [2.2.0.RELEASE] : Spring Boot web library
* **spring-boot-devtools** [2.2.0.RELEASE] : Spring Boot Dev tools Library
* **spring-boot-starter-tomcat** [2.2.0.RELEASE] : Spring Boot Tomcat library



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

Generate : WAR File



## Testing

This project has tests : Unit + Integration

Execute with IDE or Maven



## Deploy

Dockerize (Spring Boot + Docker)

Important : Use **extends SpringBootServletInitializer**

```bash
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
...
}
```

1. Execute the following command

```bash
mvn clean install
```

2. Verify exist target/<artifact> -> WAR

3. Execute the following command

Create a Docker image File

```bash
docker build -t acme/acme-greeting-api-restful-docker-tomcat .
```

* Copy the generated WAR file to tomcat/webapps directory


4. Verify exist image created

5. Execute the following command

Create a Docker container

```bash
docker run -p 8888:8080 -t acme/acme-greeting-api-restful-docker-tomcat
```


## Use

Important : Beware of the configured port


### Use Browser

The service will accept HTTP GET requests at :

```bash
http://localhost:8091/acme/greeting
```

And return JSON

```bash
{"id":1,"content":"Hello, World!","responseTime":"???"}
```

The service will accept HTTP GET requests at :

```bash
http://localhost:8091/acme/greeting?name=Acme
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
