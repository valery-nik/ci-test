package ru.oz.ci.citest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(SimpleController.class)
public class SimpleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void isAlive() throws Exception {

        mvc.perform(get("/info")).andExpect(content().string("is alive!"));

    }

}