package com.learning.library_system.controllers;

import com.learning.library_system.dto.BookDto;
import com.learning.library_system.entities.Book;
import com.learning.library_system.services.impl.IBookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final IBookService bookService;

    @PostMapping
   public ResponseEntity<BookDto> create(@RequestBody @Valid BookDto bookDto){
       return new ResponseEntity<>(bookService.createBook(bookDto), HttpStatus.CREATED);
   }

   @GetMapping("/{id}")
   public ResponseEntity<BookDto> retrieveBook(@PathVariable Integer id){
        return new ResponseEntity<>(bookService.retrieveBook(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> update(@RequestBody @Valid BookDto bookDto, @PathVariable Integer id){
        return new ResponseEntity<>(bookService.updateBook(bookDto, id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> retrieveAllBook(){
        return new ResponseEntity<>(bookService.retrieveAllBook(), HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<BookDto>> retrieveAllBookForSpecficAuthor(@PathVariable  Integer id){
        return new ResponseEntity<>(bookService.retrieveAllBookForSpecficAuthor(id), HttpStatus.OK);
    }

}
