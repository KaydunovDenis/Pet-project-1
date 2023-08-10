package com.github.kaydunovdenis.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
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
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class BookServiceImplSapientGeneratedTest {

  //Sapient generated method id: ${76c10304-bef0-3980-80be-1586e1f562c3}
  @Test()
  void getAllBooksTest() {
    //given
    BookRepository bookRepositoryMock = mock(BookRepository.class);
    BookServiceImpl target = new BookServiceImpl(bookRepositoryMock);
    List<BookEntity> bookEntities = new ArrayList<>();
    bookEntities.add(getBookEntity("name1"));
    bookEntities.add(getBookEntity("name2"));

    //when
    when(bookRepositoryMock.findAll()).thenReturn(bookEntities);

    //then
    List<BookEntity> result = target.getAllBooks();
    assertAll("result", () -> {
      assertThat(result.size(), equalTo(2));
      verify(bookRepositoryMock).findAll();
    });
  }

  //Sapient generated method id: ${2284fc3d-473b-3992-886d-8fe431bd702d}
  @Test()
  void createTest() {
    BookRepository bookRepositoryMock = mock(BookRepository.class);
    BookServiceImpl target = new BookServiceImpl(bookRepositoryMock);
    BookEntity bookEntity = new BookEntity();
    doReturn(bookEntity).when(bookRepositoryMock).save(any());
    BookDto bookDto = new BookDto();
    bookDto.setAuthor("author1");
    bookDto.setPrice(0);
    bookDto.setName("name1");
    BookEntity result = target.create(bookDto);
    assertAll("result", () -> {
      assertThat(result, equalTo(bookEntity));
      verify(bookRepositoryMock).save(any());
    });
  }

  private BookEntity getBookEntity(String name) {
    BookEntity bookEntity = new BookEntity();
    bookEntity.setName(name);
    bookEntity.setAuthor("author1");
    bookEntity.setPrice(100);
    return bookEntity;
  }


}
