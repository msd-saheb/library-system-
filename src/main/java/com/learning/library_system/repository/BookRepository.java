package com.learning.library_system.repository;

import com.learning.library_system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByTitle(String title);

    List<Book> findByPublishedDateAfter(LocalDate date);

    List<Book>  findByAuthorId(Integer authorId);
}
