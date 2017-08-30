package ru.oz.ci.citest.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleIntegrationConfig.class)
public class SampleIntegrationConfigTest {

    @Autowired
    @Qualifier("in2")
    MessageChannel in2Channell;

    @Autowired
    private SampleIntegrationConfig.InputGateway inputGateway;

    @Test
    public void mainIntegrationTest() throws Exception {
        inputGateway.run("Hello, world");
    }

    @Test
    public void runAsyncTest() throws Exception {
        inputGateway.runAsync(1);
        inputGateway.runAsync(2);
        inputGateway.runAsync(3);
        inputGateway.runAsync(4);
        inputGateway.runAsync(5);
    }

    @Test
    public void testManualSending() {
        Message<Integer> msg1 = MessageBuilder.withPayload(1).build();
        Message<Integer> msg2 = MessageBuilder.withPayload(2).build();
        Message<Integer> msg3 = MessageBuilder.withPayload(3).build();
        Message<Integer> msg4 = MessageBuilder.withPayload(4).build();

        in2Channell.send(msg1);
        in2Channell.send(msg2);
    }
}