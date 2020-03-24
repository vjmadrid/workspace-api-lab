# acme-greeting-api-restful-deployment


Important : The objective of this project is to be able to have a project to test different deployment systems

This project represents a basic API REST with **Hello World (Greeting)**

Invoke : localhost:<port>/greeting

And you receive : {"id":1,"content":"Hello, World!","responseTime":"???"}

This projects stands out for:

* Provide **Configuration classes** : Classes to configure the project (scanning package,...)
* Provide **Constant classes** : Classes to configure the project
* Provide **Basic classes** : Controller and Entity
* Provide **Properties Configuration File** with **Environment** (application-{environment}.yml)
* Provide **Log Configuration File** (logback.yml)
* Provide **Spring/Maven Profile Integration**
* Provide **Swagger** for document the Restful API
* Provide **Verify Files / Content with Verifier**
* Provide **Standard Surefire Test Filter with Profiles** (unit & integration test)
* Provide **Code Coverage with JACOCO** 
* Provide **Dockerfile**




## Different types of deployment by environment

Spring Boot provides a mechanism for applications to have a specific configuration by using the application.properties file

* key value map for project setup properties
* The file is loaded during SpringBoot startup
* Configuration properties can be defined by the Spring framework or be custom (user defined)
* The file can have the formats : .properties or .yml
* The file can be loaded from inside the JAR or it can be set in the filesystem (there are different mechanisms)
* The content of the file can make use of the environment variables


See [Spring framework properties documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)

See [Spring Boot Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config)

See [Profile-specific application properties] (https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config-profile-specific-properties)

1) Command line arguments
2) Properties from SPRING_APPLICATION_JSON
3) JNDI attributes from java:comp/env
4) Java System properties (System.getProperties())
5) OS environment variables
6) A RandomValuePropertySource that only has properties in random.*
7) Profile-specific application properties outside of your packaged jar (application-{profile}.properties and YAML variants).
8) Profile-specific application properties packaged inside your jar (application-{profile}.properties and YAML variants).
9) Application properties outside of your packaged jar (application.properties and YAML variants)
10) Application properties packaged inside your jar (application.properties and YAML variants)
11) @PropertySource annotations on your @Configuration classes
12) Default properties (specified using SpringApplication.setDefaultProperties)





### Application File Locations

Spring boot automatically loads the file from the project's classpath

Use : **src/main/resources**

There are several alternatives

* In the root classpath
* In the /config package in the classpath
* In the current directory
* In the subdirectory /config in the current directory

The higher priorities are so literally :
classpath:/,classpath:/config/,file:./,file:./config

When custom config locations are configured by using spring.config.location, they replace the default locations. For example, if spring.config.location is configured with the value classpath:/custom-config/,file:./custom-config/, the search order becomes the following:

file:./custom-config/

classpath:custom-config/




### Property Injection with @Value notation

When a property is included that is different from those used by the framework or defined by the user, it is injected into the spring framework with the @Value property

* This annotation works on the builders or on the attributes of a bean
* This annotation uses the key defined in the
* Use 
  * as "property placeholder" : ${…}
  * as "expression" #{...}
* If the key is not found, the IllegalArgumentException is returned when you try to create the bean
* In some cases you can set the properties with types : int , boolean, string, arrays, list, set, ...


```bash
*** application.properties **
 
# Comment
acme.message1=Hello Acme!
acme.message2=Hello Acme 2!
 
acme.intValue=22
 
// Default : Separates with comma
acme.list.intValue=10,6,4,3,1
 
acme.list.other.intValue=10;6;4;3;1
 
acme.version.java=Java path: ${JAVA_HOME}

*** Clase MyService ***
 
@Service
public class MyService {
 
    private final String message1;
 
    private final int valueInt;
  
    // Property + default value
    @Value("${acme.message2:Hello world}")
    private String message2;
 
    @Value("${acme.list.intValue}")
    private List<Integer> listIntValue;
 
    @Value("#{'${acme.list.other.intValue}'.split(';')}")
    private List<Integer> listOtherIntValue;
 
    MyService(@Value("${acme.message1:Hello world}") String message, @Value("${acme.intValue}") int number) {
        this.message1 = message;
        ...
   }
 
   ...
 
  
}
```





### Profile-specific configuration

Different configuration files can be used for different usage scenarios (e.g. environments)

* The management and profiles provided by Spring are often used
* Allows you to locate each of the files in the indicated paths
* The format of the file is usually : application-<profile>.properties
* No profile will be loaded that is not indicated in some way


Approaches :

* **Independent :** Each project defines each and every property (duplicate)
* **Shared :** The application.properties file contains the common part and in each of them adds or modifies the rest of properties


Invocations :

* Set spring.profiles.active in application.properties
* Set spring.profiles.active in the startup argument





### Integration with Maven

Steps 



#### 1. Mapping profiles of Spring - Maven

It is required to indicate that when choosing a certain Maven profile a certain Spring profile is used

This configuration is done on any of Maven's profile definition machines

It can be used in : pom.xml or settings.xml (all project)

```bash
<profiles>
	
	<profile>
    		<id>dev</id>
    		<properties>
        		<activatedProperties>dev</activatedProperties>
        		<spring.profiles.active>dev</spring.profiles.active>
    		</properties>
    		<activation>
        		<activeByDefault>true</activeByDefault>
    		</activation>
	</profile>
	
	<profile>
    		<id>qa</id>
    		<properties>
        		<activatedProperties>qa</activatedProperties>
        		<spring.profiles.active>qa</spring.profiles.active>
    		</properties>
	</profile>
	
	...
	
</profiles>
```



#### 2. Adapt the properties file : properties/yaml

It is required to indicate that when choosing a certain Maven profile a certain Spring profile is used

This configuration is done in a property


```bash
# Example : default value
spring:
   profiles:
      active: dev

# Example : maven property
spring:
   profiles:
      active: "@spring.profiles.active@"
 
...
```



#### 3. Filtering resources in Maven

Can be filtered so that other resources are not added when the profile is established

You can set a filter which affects only the value set in the property : spring.profiles.active=@activatedProperties@.

Use in pom.xml file

```bash
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <filtering>true</filtering>
            <excludes>
                <exclude>**/conf.properties</exclude>
            </excludes>
        </resource>
    </resources>
    …
</build>
```

Important : If the filter exists and a request is made to load another environment that is not loaded, then the default environment is loaded



### Different types of deployment

Types :


#### Single property file (internal properties file)

Only one configuration file per environment (usually the productive environment)

Use default values

2 Options :

* Independent mode
* Shared mode → With reference to the final environment

If integration with Maven is used :

* Set its value in the property : spring.profiles.active=xxx
* Define the property <activeByDefault>true</activeByDefault> in the profile of the pom.xml or setting.xml

Example

```bash
java -jar exampleApp.jar
```


#### Several property file files per environment (internal properties files)

Several configuration files per environment or need (usually corresponds to the environments)

Each of the files can have important characteristics

Uses environment defaults

2 Options :

* Independent mode
* Shared mode → With reference to the final environment


* Separate files and command line loading Mode Independent

Example

```bash
# Indepent Mode 
java -jar exampleApp.jar --spring.config.name=xxx
```


* Separate files and command line loading -> Mode Shared

Example

```bash
# Shared Mode
java -jar exampleApp.jar --spring.config.name=xxx,yyy
```


* Use of environment variable (paths or files can be referenced) -> Modes : Indepentent and Shared

Example

```bash
export SPRING_CONFIG_NAME=xxx,yyy
export SPRING_CONFIG_LOCATION=file:///Users/home/config

java -jar exampleApp.jar
```
    

* Use of Maven-Spring integration with/without resource filtering

Example

```bash
# Optional resource filtering
mvn clean package -Pxxx

java -jar exampleApp.jar
```


* Use of Maven-Spring integration with/without resource filtering command line

Example

```bash

# Optional resource filtering
mvn clean package -Pxxx 

java -jar exampleApp.jar -Dspring.profiles.active=xxx 
```


#### Several property file files per environment (external properties)

**Important :** In all the cases the use of command line parameters is used


* Loading a specific file (file or classpath)

Example

```bash
java -jar exampleApp.jar --spring.config.location=file:///Users/home/config/application-qa.properties

or

java -jar exampleApp.jar --spring.config.location=classpath:/data/example/config,classpath:/data/example/external/config
```


* Loading a specific folder + especific names

Example

```bash
java -jar exampleApp.jar --spring.config.name=xxx,yyy --spring.config.location=file:///Users/home/config
```


* Loading a specific folder + especific names

Example

```bash
java -jar exampleApp.jar --spring.config.name=xxx,yyy --spring.config.location=file:///Users/home/config
```


* Loading a specific file with Maven

Example

```bash
mvn spring-boot:run -Dspring.config.location="file:///Users/home/application-qa.properties"
```



## Technological Stack

* Java 8
* [Maven 3](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) 2.2.0.RELEASE
* [Spring](https://spring.io)
* [Docker](https://www.docker.com/) - Container Technology

Dependencies with architecture projects

N/A

Third Party Dependencies

* **spring-boot-starter-parent** [2.2.0.RELEASE] : Spring Boot + Spring Framework
* **spring-boot-starter** [X] : Spring Boot Basic core
* **spring-boot-starter-test** [X] : Spring Boot testing library
* **spring-boot-starter-web** [X] : Spring Boot web library
* **spring-boot-devtools** [X] : Spring Boot Dev tools Library
* **spring-boot-starter-actuator** [X] : Spring Boot Actuators Library

* **springfox-swagger2** [2.9.2] : Swagger
* **springfox-swagger-ui** [2.9.2] : Swagger UI





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
java -jar target/acme-greeting-api-restful-deployment-0.0.1-SNAPSHOT.jar
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
docker build -t acme/acme-greeting-api-restful-deployment .
```

* Copy the generated JAR

4. Verify exist image created

5. Execute the following command

Create a Docker container

```bash
docker run -p 8091:8091 -t acme/acme-greeting-api-restful-deployment
```





## Versioning

**Note :** [SemVer](http://semver.org/) is used for the versioning.
To see the available versions access the repository tags





## Authors

* **Víctor Madrid**
