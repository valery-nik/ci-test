# ci-test

[![Build Status](https://travis-ci.org/valery-nik/ci-test.svg?branch=master)](https://travis-ci.org/valery-nik/ci-test)

Запуск logspout'а, собирающего логи со всех контейнеров docker-host'а
https://papertrailapp.com/events - просмотр логов
docker run -d -p8000:80 \ 
--name="logspout" \
--volume=/var/run/docker.sock:/tmp/docker.sock \
amouat/logspout-logstash \
syslog://logs6.papertrailapp.com:31034

Имитация логирования
docker run -d alpine \
/bin/sh -c "while true; do echo hello world; sleep 1; done" - вывод в консоль, как пример логирования

192.168.99.100:8000/logs - тейлинг логов собираемых в logspout