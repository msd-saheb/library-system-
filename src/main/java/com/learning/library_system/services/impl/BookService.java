package com.learning.library_system.services.impl;

import com.learning.library_system.dto.AuthorDto;
import com.learning.library_system.dto.BookDto;
import com.learning.library_system.entities.Author;
import com.learning.library_system.entities.Book;
import com.learning.library_system.repository.AuthorRepository;
import com.learning.library_system.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final ModelMapper mapper;
    @Override
    public BookDto createBook(BookDto bookDto) {
        Optional<Author> author = authorRepository.findById(bookDto.getAuthor().getId());
        if(author.isPresent()){
            Book book = mapper.map(bookDto, Book.class);
            book.setAuthor(author.get());
            return mapper.map(bookRepository.save(book), BookDto.class);
        }
        throw new RuntimeException("Author is not Present");
    }

    @Override
    public BookDto retrieveBook(Integer id) {
        return mapper.map(bookRepository.findById(id), BookDto.class);
    }

    @Override
    public BookDto updateBook(BookDto bookDto, Integer id) {
        if(bookRepository.existsById(id)){
            Book existedBook = mapper.map(bookDto, Book.class);
            existedBook.setId(id);
            return mapper.map(bookRepository.save(existedBook), BookDto.class);
        }
        throw new RuntimeException("Book with the id "+id  +" doesn't exist");
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public List<BookDto> retrieveAllBook() {
        return bookRepository.findAll().stream()
                .map(book -> {
                    BookDto bookDto = mapper.map(book, BookDto.class);
                    bookDto.setAuthor(mapper.map(book.getAuthor(), AuthorDto.class));
                    return bookDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> retrieveAllBookForSpecficAuthor(Integer id) {
         return bookRepository.findByAuthorId(id)
                 .stream()
                 .map(book -> {
                     return mapper.map(book , BookDto.class);
                 }).collect(Collectors.toList());
    }
}
