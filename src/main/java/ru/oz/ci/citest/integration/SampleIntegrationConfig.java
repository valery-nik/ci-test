package ru.oz.ci.citest.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import java.util.concurrent.Future;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class SampleIntegrationConfig {

    // создание флоу, где производится опрос канала in и выводится в консоле сообщение
    @Bean
    public IntegrationFlow sampleFlow() {
        return IntegrationFlows.from("in")

                .handle(message -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("sampleFlow.handle -> " + message.getPayload());
                }).get();
    }

    // создание флоу, где производится опрос интов из канала in2
    // фильтрация на четность
    // сохранение в канал out
    @Bean
    public IntegrationFlow asyncFlow() {

        return flowDefinition ->
                flowDefinition
                        .channel("in2")
                        .handle(message -> {
                            System.out.println("asyncFlow.handle -> " + message.getPayload());
                        });
//                        .<Integer>filter(value -> value % 2 == 0)
//                        .channel("out");
//        return new  IntegrationFlow() {
//            @Override
//            public void configure(IntegrationFlowDefinition<?> flow) {
//
//            }
//        };


//        return f -> f
//                .channel("in2")
//                .<Integer>filter(value -> value % 2 == 0)
//                .channel("out");
    }

    @Bean
    public IntegrationFlow printOutFlow() {
        return IntegrationFlows.from("out")
                .handle(message -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("printOutFlow.handle -> " + message.getPayload());
                }).get();
    }


    @MessagingGateway
    public interface InputGateway {
        @Gateway(requestChannel = "in")
        void run(String payload);

        @Gateway(requestChannel = "in2")
            //, replyChannel = "out")
        Future<Void> runAsync(Integer payload);
    }
}
