package ru.oz.ci.citest.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.oz.ci.citest.enities.Book;

@Repository
public interface BookRepository extends CassandraRepository<Book> {
}
