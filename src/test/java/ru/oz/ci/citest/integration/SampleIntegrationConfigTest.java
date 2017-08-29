package ru.oz.ci.citest.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleIntegrationConfig.class)
public class SampleIntegrationConfigTest {

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
}