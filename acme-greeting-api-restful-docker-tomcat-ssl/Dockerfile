FROM tomcat:8.5.47-jdk8-corretto

RUN rm -rf /usr/local/tomcat/webapps/*

COPY ./target/acme-greeting-api-restful-docker-tomcat-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/acme.war

CMD ["catalina.sh","run"]

EXPOSE 8080