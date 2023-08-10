package com.github.kaydunovdenis.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

import com.github.kaydunovdenis.dto.BookDto;
import com.github.kaydunovdenis.dto.BookResponse;
import com.github.kaydunovdenis.entity.BookEntity;
import com.github.kaydunovdenis.service.BookService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class BooksControllerSapientGeneratedTest {

  //Sapient generated method id: ${76c10304-bef0-3980-80be-1586e1f562c3}
  @Test()
  void getAllBooksTest() {
    BookService bookServiceMock = mock(BookService.class);
    BooksController target = new BooksController(bookServiceMock);
    List<BookEntity> bookEntityList = new ArrayList<>();
    doReturn(bookEntityList).when(bookServiceMock).getAllBooks();
    List<BookEntity> result = target.getAllBooks();
    assertAll("result", () -> {
      assertThat(result, equalTo(bookEntityList));
      verify(bookServiceMock).getAllBooks();
    });
  }

  //Sapient generated method id: ${b324d0bd-f97a-3c1b-b3b8-14f6ce50180a}
  @Test()
  void getBookTest() {
    BookResponse bookResponseMock = mock(BookResponse.class);
    ResponseEntity<BookResponse> responseEntityMock = mock(ResponseEntity.class);
    BookService bookServiceMock = mock(BookService.class);
    try (MockedStatic<ResponseEntity> responseEntity = mockStatic(ResponseEntity.class, CALLS_REAL_METHODS);
         MockedStatic<BookResponse> bookResponse = mockStatic(BookResponse.class, CALLS_REAL_METHODS)) {
      bookResponse.when(() -> BookResponse.toBookResponse((BookEntity) any())).thenReturn(bookResponseMock);
      responseEntity.when(() -> ResponseEntity.ok(bookResponseMock)).thenReturn(responseEntityMock);
      BooksController target = new BooksController(bookServiceMock);
      BookEntity bookEntity = new BookEntity();
      doReturn(bookEntity).when(bookServiceMock).getBook(1L);
      ResponseEntity<BookResponse> result = target.getBook(1L);
      assertAll("result", () -> {
        assertThat(result, equalTo(responseEntityMock));
        bookResponse.verify(() -> BookResponse.toBookResponse((BookEntity) any()), atLeast(1));
        responseEntity.verify(() -> ResponseEntity.ok(bookResponseMock), atLeast(1));
        verify(bookServiceMock).getBook(1L);
      });
    }
  }

  //Sapient generated method id: ${77346bfa-2926-3f88-a8d3-1174db738ac9}
  @Test()
  void deleteBookTest() {
    BookService bookServiceMock = mock(BookService.class);
    BooksController target = new BooksController(bookServiceMock);
    doNothing().when(bookServiceMock).delete(1L);
    ResponseEntity<BookResponse> result = target.deleteBook(1L);
    ResponseEntity<BookResponse> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
    assertAll("result", () -> {
      assertThat(result, equalTo(responseEntity));
      verify(bookServiceMock).delete(1L);
    });
  }

  //Sapient generated method id: ${1b8370f4-912b-31af-bd6b-e27024024940}
  @Test()
  void createBookTest() {
    BookResponse bookResponseMock = mock(BookResponse.class);
    ResponseEntity<BookResponse> responseEntityMock = mock(ResponseEntity.class);
    BookService bookServiceMock = mock(BookService.class);
    try (MockedStatic<ResponseEntity> responseEntity = mockStatic(ResponseEntity.class, CALLS_REAL_METHODS);
         MockedStatic<BookResponse> bookResponse = mockStatic(BookResponse.class, CALLS_REAL_METHODS)) {
      bookResponse.when(() -> BookResponse.toBookResponse((BookEntity) any())).thenReturn(bookResponseMock);
      responseEntity.when(() -> ResponseEntity.ok(bookResponseMock)).thenReturn(responseEntityMock);
      BooksController target = new BooksController(bookServiceMock);
      BookEntity bookEntity = new BookEntity();
      doReturn(bookEntity).when(bookServiceMock).create((BookDto) any());
      BookDto bookDto = new BookDto();
      ResponseEntity<BookResponse> result = target.createBook(bookDto);
      assertAll("result", () -> {
        assertThat(result, equalTo(responseEntityMock));
        bookResponse.verify(() -> BookResponse.toBookResponse((BookEntity) any()), atLeast(1));
        responseEntity.verify(() -> ResponseEntity.ok(bookResponseMock), atLeast(1));
        verify(bookServiceMock).create((BookDto) any());
      });
    }
  }

  //Sapient generated method id: ${ae8b01c3-8eb2-3a97-bb44-36b1c3580b9b}
  @Test()
  void updateBookTest() {
    BookResponse bookResponseMock = mock(BookResponse.class);
    ResponseEntity<BookResponse> responseEntityMock = mock(ResponseEntity.class);
    BookService bookServiceMock = mock(BookService.class);
    try (MockedStatic<ResponseEntity> responseEntity = mockStatic(ResponseEntity.class, CALLS_REAL_METHODS);
         MockedStatic<BookResponse> bookResponse = mockStatic(BookResponse.class, CALLS_REAL_METHODS)) {
      bookResponse.when(() -> BookResponse.toBookResponse((BookEntity) any())).thenReturn(bookResponseMock);
      responseEntity.when(() -> ResponseEntity.ok(bookResponseMock)).thenReturn(responseEntityMock);
      BooksController target = new BooksController(bookServiceMock);
      BookEntity bookEntity = new BookEntity();
      doReturn(bookEntity).when(bookServiceMock).update((BookDto) any(), eq(1L));
      BookDto bookDto = new BookDto();
      ResponseEntity<BookResponse> result = target.updateBook(bookDto, 1L);
      assertAll("result", () -> {
        assertThat(result, equalTo(responseEntityMock));
        bookResponse.verify(() -> BookResponse.toBookResponse((BookEntity) any()), atLeast(1));
        responseEntity.verify(() -> ResponseEntity.ok(bookResponseMock), atLeast(1));
        verify(bookServiceMock).update((BookDto) any(), eq(1L));
      });
    }
  }
}
