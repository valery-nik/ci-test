FROM java:8-jre
MAINTAINER Igor Ozol <ystal@mail.ru>

ADD ./target/ci-test.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/ci-test.jar"]

EXPOSE 8080