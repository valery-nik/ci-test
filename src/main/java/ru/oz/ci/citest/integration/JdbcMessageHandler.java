package ru.oz.ci.citest.integration;

import lombok.extern.slf4j.Slf4j;
import ru.oz.ci.citest.enities.Article;

import java.util.List;

@Slf4j
public class JdbcMessageHandler {

    public void handleMessage1(List<Article> articleList) {
        log.info("In JdbcMessageHandler:" + articleList);
    }

    public void handleMessage2(List<Article> articleList) {
        log.info("In JdbcMessageHandler:" + articleList);
    }

}
