package com.learning.library_system.services.impl;

import com.learning.library_system.dto.BookDto;
import com.learning.library_system.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookService {

    public BookDto createBook(BookDto authorDto);

    public BookDto retrieveBook(Integer id);

    public BookDto updateBook(BookDto authorDto, Integer id);

    public void deleteBook(Integer id);

    public List<BookDto> retrieveAllBook();

    public List<BookDto> retrieveAllBookForSpecficAuthor(Integer id);
}
