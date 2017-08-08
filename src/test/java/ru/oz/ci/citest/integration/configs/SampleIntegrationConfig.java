package ru.oz.ci.citest.integration.configs;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import java.util.concurrent.Future;

@TestConfiguration
public class SampleIntegrationConfig {

    public IntegrationFlow sampleFlo() {
        return IntegrationFlows.from("in")
                .handle(message -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    System.out.println(message.getPayload());
                }).get();
    }

    public IntegrationFlow asyncFlow() {
        return f -> f.channel("in2").filter(value -> (int)value % 2 == 0)
                .channel("out");
    }

    @MessagingGateway
    public interface InputGateway {

        @Gateway(requestChannel = "in")
        void run(String payload); // синхронный канал

        @Gateway(requestChannel = "in2", replyChannel = "out")
        Future<Void> runAsync(Integer payload); // асинхронный канал, Future живет пока сообщение не попадет в "out"
    }
}
