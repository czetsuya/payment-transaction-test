FROM adoptopenjdk/openjdk11:alpine

ENV TZ=Asia/Singapore

RUN apk add --no-cache ttf-dejavu

ADD docker-entrypoint.sh /
ARG JAR_FILE=target/*.jar

RUN addgroup -S springUser && \
    adduser -u 2001 -S springUser -G springUser && \
    chmod a+x /docker-entrypoint.sh && \
    mkdir /apps

COPY ${JAR_FILE} /apps/app.jar

USER springUser:springUser

EXPOSE 8080

ENTRYPOINT [ "/docker-entrypoint.sh" ]