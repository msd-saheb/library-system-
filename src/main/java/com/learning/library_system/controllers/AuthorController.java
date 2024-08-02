package com.learning.library_system.controllers;

import com.learning.library_system.dto.AuthorDto;
import com.learning.library_system.dto.BookDto;
import com.learning.library_system.services.impl.IAuthorService;
import com.learning.library_system.services.impl.IBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final IAuthorService authorService;

    @PostMapping
   public ResponseEntity<AuthorDto> create(@RequestBody @Valid AuthorDto authorDto){
       return new ResponseEntity<>(authorService.createAuthor(authorDto), HttpStatus.CREATED);
   }

   @GetMapping("/{id}")
   public ResponseEntity<AuthorDto> retrieveAuthor(@PathVariable Integer id){
        return new ResponseEntity<>(authorService.retrieveAuthor(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> update(@RequestBody @Valid AuthorDto authorDto, @PathVariable Integer id){
        return new ResponseEntity<>(authorService.updateAuthor(authorDto, id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> retrieveAllAuthor(){
        return new ResponseEntity<>(authorService.retrieveAllAuthor(), HttpStatus.OK);
    }

}
