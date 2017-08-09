package ru.oz.ci.citest.integration;

import org.junit.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;

import java.util.Scanner;

@TestConfiguration
@ContextConfiguration(classes = FtpIntegrationConfiguration.class)
public class TestFtpIntegration {

    @Test
    public void sampleTest() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter q and press <enter> to exit the program: ");
        while (true) {
            String input = scanner.nextLine();
            if("q".equals(input.trim())) {
                break;
            }
        }
        System.exit(0);
    }
}
