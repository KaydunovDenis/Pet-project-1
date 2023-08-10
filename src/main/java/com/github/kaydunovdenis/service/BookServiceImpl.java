package com.github.kaydunovdenis.service;

import com.github.kaydunovdenis.dto.BookDto;
import com.github.kaydunovdenis.entity.BookEntity;
import com.github.kaydunovdenis.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public List<BookEntity> getAllBooks() {
    List<BookEntity> bookEntities = new ArrayList<>();
    bookRepository.findAll().forEach(bookEntities::add);
    return bookEntities;
  }

  @Override
  public BookEntity update(BookDto book, long id) {
    BookEntity entity = getBook(id);
    entity.setPrice(book.getPrice());
    entity.setName(book.getName());
    entity.setAuthor(book.getAuthor());

    return entity;
  }

  public BookEntity getBook(long id) {
    return bookRepository.findById(id)
        .orElseThrow(() -> new RuntimeException(String.format("Book with id '%s' is not found", id)));
  }

  public BookEntity create(BookDto book) {
    BookEntity bookEntity = new BookEntity();
    bookEntity.setAuthor(book.getAuthor());
    bookEntity.setName(book.getName());
    bookEntity.setPrice(book.getPrice());
    return bookRepository.save(bookEntity);
  }

  public void delete(long id) {
    BookEntity book = getBook(id);
    bookRepository.delete(book);
  }

}
