package ru.oz.ci.citest.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestIntegrationConfiguration.class)
@TestPropertySource(locations="classpath:application-test.properties")
public class TestFooIntegration {

    @Test
    public void test() throws Exception {
        System.out.println("Test worked...");
    }
}
