package com.learning.library_system.repository;

import com.learning.library_system.entities.Author;
import com.learning.library_system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findByName(String name);

}
