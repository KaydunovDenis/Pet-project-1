package com.github.kaydunovdenis.service;

import com.github.kaydunovdenis.dto.BookDto;
import com.github.kaydunovdenis.entity.BookEntity;

import java.util.List;

public interface BookService {

    BookEntity getBook(long id);

    List<BookEntity> getAllBooks();

    BookEntity update(BookDto book, long id);

    void delete(long id);

    BookEntity create(BookDto book);
}
