FROM java:8-jre
MAINTAINER Igor Ozol <ystal@mail.ru>

ADD ./target/ci-test.jar /app/
EXPOSE 8080

USER ystal
CMD ["java", "-Xmx200m", "-jar", "/app/ci-test.jar"]
