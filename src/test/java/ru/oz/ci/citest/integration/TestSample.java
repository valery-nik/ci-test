package ru.oz.ci.citest.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.oz.ci.citest.integration.configs.SampleIntegrationConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SampleIntegrationConfig.class)
public class TestSample {

    @Test
    public void sample() throws Exception {

    }
}
