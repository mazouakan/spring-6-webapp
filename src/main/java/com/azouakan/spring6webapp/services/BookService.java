package com.azouakan.spring6webapp.services;

import com.azouakan.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
