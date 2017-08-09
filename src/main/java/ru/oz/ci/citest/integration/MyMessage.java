package ru.oz.ci.citest.integration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyMessage {
    int id;

    String massage;
    String from;
    String to;
}
