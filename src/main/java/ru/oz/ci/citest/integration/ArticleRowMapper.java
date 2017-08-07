package ru.oz.ci.citest.integration;

import org.springframework.jdbc.core.RowMapper;
import ru.oz.ci.citest.enities.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ArticleRowMapper implements RowMapper<Article> {

    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("name");
        String category = rs.getString("category");
        String author = rs.getString("author");
        String tags = rs.getString("tags");
        int id = rs.getInt("id");

        Article article = new Article();
        article.setId(UUID.fromString(String.valueOf(id)));
        article.setCategory(category);
        article.setAuthor(author);
        article.setName(name);
        article.setTags(tags);

        return article;
    }
}