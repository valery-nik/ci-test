package ru.oz.ci.citest.enities;

import lombok.Data;
import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.UUID;

@Data
@Table
public class Article {

    @PrimaryKeyColumn(
            name = "id",
            ordinal = 2,
            type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.DESCENDING)
    private UUID id;

    @PrimaryKeyColumn(
            name = "name", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String name;

    @PrimaryKeyColumn(
            name = "tags", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String tags;

    @PrimaryKeyColumn(
            name = "category", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String category;

    @PrimaryKeyColumn(
            name = "author", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String author;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags='" + tags + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
