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
}