package ru.oz.ci.citest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @RequestMapping("/info")
    public String isAlive() {
        return "is alive!";
    }
}
