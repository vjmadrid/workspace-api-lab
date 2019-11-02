From tomcat:8.5.47-jdk8-corretto

EXPOSE 8080
EXPOSE 8091

RUN rm -rf /usr/local/tomcat/webapps/*

COPY ./target/acme-greeting-api-restful-docker-tomcat-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/acme-greeting-api-restful-docker-tomcat.war

CMD ["catalina.sh","run"]