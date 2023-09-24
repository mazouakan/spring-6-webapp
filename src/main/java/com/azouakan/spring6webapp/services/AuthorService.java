package com.azouakan.spring6webapp.services;

import com.azouakan.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();

}
