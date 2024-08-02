package com.learning.library_system.services.impl;

import com.learning.library_system.dto.AuthorDto;
import com.learning.library_system.dto.BookDto;
import com.learning.library_system.entities.Author;
import com.learning.library_system.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService{

    private final AuthorRepository authorRepository;

    private final ModelMapper mapper;
    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = mapper.map(authorDto, Author.class);
       return mapper.map(authorRepository.save(author), AuthorDto.class);
    }

    @Override
    public AuthorDto retrieveAuthor(Integer id) {
        return mapper.map(authorRepository.findById(id), AuthorDto.class);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, Integer id) {
        if(authorRepository.existsById(id)){
            Author author = mapper.map(authorDto , Author.class);
            author.setId(id);
            return mapper.map(authorRepository.save(author), AuthorDto.class);
        }
        throw new RuntimeException("Author not present!!!");
    }

    @Override
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDto> retrieveAllAuthor() {
       return authorRepository.findAll()
               .stream()
               .map(author -> mapper.map(author, AuthorDto.class))
               .collect(Collectors.toList());
    }
}
