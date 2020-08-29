package com.example.Spring5WebApp.Repositories;

import com.example.Spring5WebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
