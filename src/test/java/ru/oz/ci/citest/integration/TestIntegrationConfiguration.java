package ru.oz.ci.citest.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.endpoint.MethodInvokingMessageSource;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.stream.CharacterStreamReadingMessageSource;
import org.springframework.integration.stream.config.ConsoleInboundChannelAdapterParser;
import org.springframework.integration.support.MutableMessage;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@EnableIntegration
public class TestIntegrationConfiguration {

//    @Bean
//    public MessageSource<?> integerMessageSource() {
//        MethodInvokingMessageSource source = new MethodInvokingMessageSource();
//        source.setObject(new AtomicInteger());
//        source.setMethodName("getAndIncrement");
//        return source;
//    }

    @Bean
    public DirectChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow inputFlow() {
        return IntegrationFlows.from(CharacterStreamReadingMessageSource.stdin(), c ->
                            c.poller(Pollers.fixedRate(100)))
                .channel(this.inputChannel())
//                .filter((Integer p) -> p > 0)
                .transform((message) -> message + " was transformed.")
                .handle((payload, header) -> {
                    System.out.println("was handled =" + new MutableMessage(payload, header));
                    return payload;
                })
                .channel(MessageChannels.queue("recieved"))
                .get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata defaultPoller() {

        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setTrigger(new PeriodicTrigger(10));
        return pollerMetadata;
    }

    @Bean
    public IntegrationFlow outputFlow() {
        return IntegrationFlows.from("recieved")
                .transform("outputFlow Hello "::concat)
                .handle((message) -> {
                    System.out.printf(message.getPayload().toString());
                })
                .get();
    }


//    @Bean
//    public IntegrationFlow fileReadingFlow() {
//        return IntegrationFlows
//                .from(s -> s.file(tmpDir.getRoot()).patternFilter("*.sitest"),
//                        e -> e.poller(Pollers.fixedDelay(100)))
//                .transform(Transformers.fileToString())
//                .channel(MessageChannels.queue("fileReadingResultChannel"))
//                .get();
//    }


//    @Bean
//    public IntegrationFlow inputFlow() {
//        return IntegrationFlows.from("input")
//                .filter("World"::equals)
//                .transform("Hello "::concat)
//                .handle(System.out::println)
//                .get();
//    }

//    @Bean
//    public MessageChannel priorityChannel() {
//        return MessageChannels.priority(this.mongoDbChannelMessageStore, "priorityGroup")
//                .interceptor(wireTap())
//                .get();
//    }
//
//    @Bean
//    public MessageSource<Object> jdbcMessageSource() {
//        return new Adapter(this.dataSource, "SELECT * FROM foo");
//    }
//
//    @Bean
//    public MessageSource<Object> jdbcMessageSource() {
//        return new JdbcPollingChannelAdapter(this.dataSource, "SELECT * FROM foo");
//    }
}
