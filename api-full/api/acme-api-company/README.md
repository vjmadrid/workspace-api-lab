# dae-api-company

Este proyecto representa un microservicio encargado de realizar un CRUD sobre la entidad "Compañia"

Esta librería destaca por :

**DESARROLLO**

* Proporcionar **clases de configuración** : Clases de configuración del proyecto (escaneo de paquetes, web, environment, aspect...)
* Proporcionar **clases constantes de configuración** : Clases de constantes de configuración
* Proporcionar **clases de constantes** : Clases de constantes para el uso en el proyecto
* Proporcionar **clases genéricas** para el funcionamiento : Controller, Service, Repository, Entity, Validator, Util, DTO, ...
* Diferentes controladores : CRUD, Paginación, Filtro, etc.
* Proporcionar **ficheros de properties para configuracion** con **entorno** (application-{environment}.yml)
* Proporcionar **ficheros de configuracion de loggin** para diferentes ámbitos de ejecución (logback.yml y logback-test.yml)
* Proporcionar **integración de perfiles Spring/Maven**
* Proporcionar **Custom Banner** informativo
* Proporcionar **Swagger** para documentar Restful API
* Proporcionar **mecanismo genérico** para generar los ficheros de Swagger en JSON y YAML  
* Proporcionar **Dockerfile**
* Proporcionar **integracion CORS (Cross-Origin Resource Sharing )** con **Controller**

**TESTING**

* Proporcionar **testing** unitario e integración
* Proporcionar **clases dummy** para generar juegos de datos concretos
* Proporcionar **integración H2**
* Proporcionar **integración Liquibase**
* Proporcionar **integración con Surefire Test Filter** (test unitarios + test con contexto)
* Proporcionar **cobertura de código** con **Jacoco** 
* Proporcionar **referencias cURL REST**
* Proporcionar **integración con Postman** : Ficheros de invocaciones postman para probar la aplicación

**QA**

* Proporcionar **integración con plugin verifier de Maven** para verificar comprobaciones de construcción


Condiciones de construcción / despliegue :

* Despliegue como microservicio
* Control de cobertura del 80% a nivel de paquete



## Stack Tecnológico

* Java 8
* [Maven 3](https://maven.apache.org/) - Gestión de Dependencias
* [Spring Boot](https://spring.io/projects/spring-boot) - 2.2.0.RELEASE
* [Spring](https://spring.io)
* [Docker](https://www.docker.com/) - Tecnología de contenedores






## Pre-Requisitos

* Java 8 instalado (requerida la versión 1.5+  OpendJDK) 
* Maven instalado  (3+)
* Docker instalado (19+)





## Instalación

Pasos a seguir

* Arrancar un terminal
* Localizar el PATH de instalación (el lugar donde se encuentra el proyecto)
* Verificar que el fichero "pom.xml" esta disponible

Ejecutar el siguiente comando

```bash
mvn clean install
```

El resultado será la generación de un artefacto en el repositorio Maven local

Genera : Fichero JAR





## Testing

Este proyecto contine test : unitarios + integración

Ejecutar desde el IDE o MAven




# Despliegue

Se hará uso del despliegue como JAR


Debido a la configuración del proyecto se requiere el uso de la integración Maven/Spring

* spring.profiles.active=@spring.profiles.active@
* enable resource filtering


Se empaqueta la aplicación en un fichero single/fat JAR file (ejecutable del JAR + todas las dependencias + Embedded Servlet)

IMPORTANTE : TENER EN CUENTA QUE EXISTEN DIFERENTES ENTORNOS "dev", "uat" y "pro"


1. Ejecutar el siguiente comando

```bash
mvn package

or

mvn package -P<id_profile>
```

2. Verificar el empaquetado

3. Ejecutar

```bash
java -jar target/dae-api-company-0.0.1-SNAPSHOT.jar
```

Opcional : Cambiar puertos de arranque

```bash
java -jar -Dserver.port=8081 -Dmanagement.server.port=8081 dae-api-company-0.0.1-SNAPSHOT.jar
```





## Swagger

Para probar que se encuentra desplegado:

```bash
http://localhost:<puerto>/v2/api-docs
```

Y devovler JSON con meta información del API


Ejecutar swagger UI swagger-ui.html


```bash
http://localhost:<puerto>/swagger-ui.html
```






## Referencias "cURL"


```bash
curl -i -X GET -H "Content-Type:application/json" http://localhost:<port>/companies
```

GET findByPk = 2

```bash
curl -i -X GET -H "Content-Type:application/json" http://localhost:<port>/companies/2
```

POST insert

```bash
curl -i -X POST -H "Content-Type:application/json" -d "{\"companyName\":\"cURL company\"}"  http://localhost:<port>/companies
```

PUT update

```bash
curl -i -X PUT -H "Content-Type:application/json" -d "{\"companyName\":\"cURL updated company\"}"  http://localhost:<port>/companies/2
```

DELETE delete

```bash
curl -i -X DELETE -H "Content-Type:application/json" http://localhost:<port>/companies/2
```





## Dockerize

Dockerize (Spring Boot + Docker)

1. Ejecute el siguiente comando

```bash
mvn clean install -P<id_profile>
```

2. Verificar que existe target/<artifact> -> JAR

3. Ejecutar el siguiente comando

Crear la imagen Docker

```bash
docker build -t cistec/dae-api-company .
```

4. Verificar que existe la imagen creada

5. Ejecutar el siguiente comando

Create a Docker container

```bash
docker run -p 8091:8091 -t cistec/dae-api-company
```





## Versionada

**Nota :** [SemVer](http://semver.org/) es utilizado por el versionado

Para ver las versiones disponibles ver los tags del repositorio





## Autores

* **atSistemas**

