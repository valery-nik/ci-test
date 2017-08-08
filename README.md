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

Spring integration

Ссылки:
    https://www.youtube.com/watch?v=DIRXR9gI_Rc
    http://www.javarticles.com/2015/05/spring-integration-file-adapter-example.html
    http://www.javarticles.com/2015/05/spring-integration-gateway-example.html

Каналы 
    - DirectChannel - паттерн Dispatcher(Observer)
    - QueueChannel - стандартная очередь (Queue)
По умолчанию сетевого обмена мессаджами нет, но в любой момент можно перейти на сетевое общение, 
   для этого есть адапторы:
     - AMQP
     - Kafka
     - websockets
     - mail
     - ftp
     - STOMP и т.д.
    
Flow (потоки или цепочки) - конфигурирование взаимодействия между каналами.
ErrorHandlers - каналы-обработчики ошибочных сообщений
ServiceActivators - сервисы Spring Core для вызова SI (для общения с приложением из вне)
Gateways - интерфейсы SI для отправки сообщений из Spring Core (для общения с приложением из вне)