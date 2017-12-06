# SpringCloud Application on Kubernetes

## Code reference
[https://github.com/binblee/springcloud-swarm](https://github.com/binblee/springcloud-swarm)

## Build image and run it using docker-compose

```
cd deploy
docker-compose build
docker-compose up -d
```

### Access the application

Find out all mapping ports of Eureka and web services:

```
$ docker-compose ps
Name                      Command               State            Ports
---------------------------------------------------------------------------------------
deploy_bookservice_1   sh -c java $JAVA_OPTS -Dja ...   Up      8080/tcp
deploy_eureka_1        sh -c java $JAVA_OPTS -Dja ...   Up      0.0.0.0:32769->8761/tcp
deploy_web_1           sh -c java $JAVA_OPTS -Dja ...   Up      0.0.0.0:32770->8080/tcp
```

In this case, Eureka server is available at URL http://localhost:32769.
Web service is available at http://localhost:32770, and you should be able to get this:

```
$ curl http://localhost:32770
BOOKSERVICE available
```

## Deploy to Kubernetes cluster

TBD


## P.S. Java 9 support

Due to Java 9 new module features, some Eureka dependencies are removed from JRE, so you have to manually include them into pom.xml.

```xml
<!-- java 9 -->
<dependency>
  <groupId>javax.xml.bind</groupId>
  <artifactId>jaxb-api</artifactId>
  <version>2.3.0</version>
</dependency>

<dependency>
  <groupId>com.sun.xml.bind</groupId>
  <artifactId>jaxb-impl</artifactId>
  <version>2.3.0</version>
</dependency>

<dependency>
  <groupId>com.sun.xml.bind</groupId>
  <artifactId>jaxb-core</artifactId>
  <version>2.3.0</version>
</dependency>

<dependency>
  <groupId>javax.activation</groupId>
  <artifactId>activation</artifactId>
  <version>1.1.1</version>
</dependency>
```

Check [pom.xml](eureka/pom.xml) for details.
