package com.github.kaydunovdenis.controller;

import com.github.kaydunovdenis.dto.BookDto;
import com.github.kaydunovdenis.dto.BookResponse;
import com.github.kaydunovdenis.entity.BookEntity;
import com.github.kaydunovdenis.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(BookResponse.toBookResponse(bookService.getBook(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(BookResponse.toBookResponse(bookService.create(bookDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@RequestBody BookDto bookDto, @PathVariable Long id) {
        return ResponseEntity.ok(BookResponse.toBookResponse(bookService.update(bookDto, id)));
    }
}
