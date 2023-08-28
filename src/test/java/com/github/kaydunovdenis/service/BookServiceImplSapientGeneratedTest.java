package com.github.kaydunovdenis.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.kaydunovdenis.dto.BookDto;
import com.github.kaydunovdenis.entity.BookEntity;
import com.github.kaydunovdenis.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class BookServiceImplSapientGeneratedTest {

  private BookEntity getBookEntity(String name) {
    BookEntity bookEntity = new BookEntity();
    bookEntity.setName(name);
    bookEntity.setAuthor("author1");
    bookEntity.setPrice(100);
    return bookEntity;
  }

  //Sapient generated method id: ${76c10304-bef0-3980-80be-1586e1f562c3}
  @Test()
  void getAllBooksTest() {
    BookRepository bookRepositoryMock = mock(BookRepository.class);
    BookServiceImpl target = new BookServiceImpl(bookRepositoryMock);
    List<BookEntity> bookEntities = new ArrayList<>();
    bookEntities.add(getBookEntity("name1"));
    bookEntities.add(getBookEntity("name2"));

    //when
    when(bookRepositoryMock.findAll()).thenReturn(bookEntities);

    //When
    List<BookEntity> result = target.getAllBooks();

    //Then
    assertAll("result", () -> {
      assertThat(result.size(), equalTo(bookEntities.size()));
      verify(bookRepositoryMock).findAll();
    });
  }

  //Sapient generated method id: ${d78c469e-0cb9-37be-bc81-7bb08610b10c}
  @Test()
  void updateThrowsRuntimeException() {
    BookRepository bookRepositoryMock = mock(BookRepository.class);
    BookServiceImpl target = new BookServiceImpl(bookRepositoryMock);
    doReturn(Optional.empty()).when(bookRepositoryMock).findById(1L);
    BookDto bookDtoMock = mock(BookDto.class);
    RuntimeException runtimeException = new RuntimeException("Book with id '1' is not found");
    final RuntimeException result = assertThrows(RuntimeException.class, () -> target.update(bookDtoMock, 1L));
    assertAll("result", () -> {
      assertThat(result, is(notNullValue()));
      assertThat(result.getMessage(), equalTo(runtimeException.getMessage()));
      verify(bookRepositoryMock).findById(1L);
    });
  }

  //Sapient generated method id: ${cc47225e-7206-3320-a5eb-5fef1e0f788b}
  @Test()
  void getBookThrowsRuntimeException() {
    BookRepository bookRepositoryMock = mock(BookRepository.class);
    BookServiceImpl target = new BookServiceImpl(bookRepositoryMock);
    doReturn(Optional.empty()).when(bookRepositoryMock).findById(1L);
    RuntimeException runtimeException = new RuntimeException("Book with id '1' is not found");
    final RuntimeException result = assertThrows(RuntimeException.class, () -> target.getBook(1L));
    assertAll("result", () -> {
      assertThat(result, is(notNullValue()));
      assertThat(result.getMessage(), equalTo(runtimeException.getMessage()));
      verify(bookRepositoryMock).findById(1L);
    });
  }

  //Sapient generated method id: ${2284fc3d-473b-3992-886d-8fe431bd702d}
  @Test()
  void createTest() {
    BookRepository bookRepositoryMock = mock(BookRepository.class);
    BookServiceImpl target = new BookServiceImpl(bookRepositoryMock);
    BookEntity bookEntityMock = mock(BookEntity.class);
    doReturn(bookEntityMock).when(bookRepositoryMock).save(any());
    BookDto bookDto = new BookDto();
    bookDto.setAuthor("author1");
    bookDto.setPrice(0);
    bookDto.setName("name1");
    BookEntity result = target.create(bookDto);
    assertAll("result", () -> {
      assertThat(result, equalTo(bookEntityMock));
      verify(bookRepositoryMock).save(any());
    });
  }

  //Sapient generated method id: ${93b08f08-ec76-3593-925e-baac955735aa}
  @Test()
  void deleteThrowsRuntimeException() {
    BookRepository bookRepositoryMock = mock(BookRepository.class);
    BookServiceImpl target = new BookServiceImpl(bookRepositoryMock);
    doReturn(Optional.empty()).when(bookRepositoryMock).findById(1L);
    RuntimeException runtimeException = new RuntimeException("Book with id '1' is not found");
    final RuntimeException result = assertThrows(RuntimeException.class, () -> target.delete(1L));
    assertAll("result", () -> {
      assertThat(result, is(notNullValue()));
      assertThat(result.getMessage(), equalTo(runtimeException.getMessage()));
      verify(bookRepositoryMock).findById(1L);
    });
  }
}
