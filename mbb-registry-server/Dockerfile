FROM openjdk:8-jdk-alpine
#RUN apk add --no-cache tzdata
RUN apk add --update \
    curl \
    && rm -rf /var/cache/apk/*
#ENV TZ Asia/Kuala_Lumpur
ENV TZ America/NewYork
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8761
ENTRYPOINT exec java $JAVA_OPTS -Xverify:none -Djava.security.egd=file:/dev/./urandom -jar /app.jar