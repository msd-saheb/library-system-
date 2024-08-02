package com.learning.library_system.services.impl;

import com.learning.library_system.dto.AuthorDto;

import java.util.List;

public interface IAuthorService {

    public AuthorDto createAuthor(AuthorDto authorDto);

    public AuthorDto retrieveAuthor(Integer id);

    public AuthorDto updateAuthor(AuthorDto authorDto, Integer id);

    public void deleteAuthor(Integer id);

    public List<AuthorDto> retrieveAllAuthor();
}
