FROM maven:3.8.3 AS maven
LABEL MAINTAINER="elton.jd.goncalves@gmail.com"

WORKDIR /app
COPY . /app
RUN mvn package 

FROM maven:3.8.3-openjdk-17

WORKDIR /opt/app
COPY --from=maven /app/target/api-lancamento.jar /opt/app/

ENTRYPOINT ["java","-jar","api-lancamento.jar"]