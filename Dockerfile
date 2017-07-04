FROM nimmis/alpine-java:openjdk-8-jdk
MAINTAINER Igor Ozol <ystal@mail.ru>
VOLUME /tmp
ADD ./target/ci-test.jar /app.jar

RUN useradd -s /bin/bash ystal
USER ystal

RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
EXPOSE 8080

#CMD ["java", "-Xmx200m", "-jar", "/app/ci-test.jar"]
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
