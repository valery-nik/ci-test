package ru.oz.ci.citest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SimpleController {

    @RequestMapping("/info")
    public String isAlive() {
        // logging
        log.info("is alive by sl4j");
        System.out.println("is alive by System.out");
        System.err.println("is alive by System.err");

        return "is alive!";
    }

    @Async
    @RequestMapping("/submit")
    public String submitTask() {
        return "task submited";
    }
}
