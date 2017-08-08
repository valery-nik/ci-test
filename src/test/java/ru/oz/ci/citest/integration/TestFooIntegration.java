package ru.oz.ci.citest.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.oz.ci.citest.integration.configs.TestIntegrationConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestIntegrationConfiguration.class)
@TestPropertySource(locations="classpath:application-test.properties")
public class TestFooIntegration {

    @Autowired
    DirectChannel inputChannel;

    @Test
    public void test() throws Exception {

//        while (true) {
//
//        }

        Message<String> message1 = MessageBuilder.withPayload(
                "Hello world - one!").build();
        Message<String> message2 = MessageBuilder.withPayload(
                "Hello world - two!").build();
        Message<String> message3 = MessageBuilder.withPayload(
                "Hello world - three!").build();
        System.out.println("sending message1");
        inputChannel.send(message1);
        System.out.println("sending message2");
        inputChannel.send(message2);
        System.out.println("sending message3");
        inputChannel.send(message3);
        System.out.println("done sending messages");

        // System.out.println("Test worked...");
    }
}
