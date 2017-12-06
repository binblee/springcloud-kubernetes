FROM maven:3-jdk-8-slim AS build-env

COPY m2_settings.xml /root/.m2/settings.xml

WORKDIR /app
COPY . /app
RUN mvn package

FROM openjdk:8-jre-slim
COPY --from=build-env /app/target/*.jar /app.jar

ENV JAVA_OPTS=""
ENV EUREKA_SERVER_ADDRESS=http://localhost:8761/eureka
ENV SERVER_PORT 8080

EXPOSE ${SERVER_PORT}

HEALTHCHECK --interval=10s --timeout=3s \
	CMD curl -v --fail http://localhost:${SERVER_PORT} || exit 1

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
