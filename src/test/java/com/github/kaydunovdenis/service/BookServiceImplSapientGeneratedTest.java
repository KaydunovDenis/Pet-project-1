package com.github.kaydunovdenis.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.github.kaydunovdenis.dto.BookDto;
import com.github.kaydunovdenis.entity.BookEntity;
import com.github.kaydunovdenis.repository.BookRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class BookServiceImplSapientGeneratedTest {

  //Sapient generated method id: ${76c10304-bef0-3980-80be-1586e1f562c3}
  @Test()
  void getAllBooksTest() {
    /** TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.*  The test code, including the assertion statements, has been successfully generated.*/
    BookRepository bookRepositoryMock = mock(BookRepository.class);
    BookServiceImpl target = new BookServiceImpl(bookRepositoryMock);
    Iterable iterableMock = mock(Iterable.class);
    doReturn(iterableMock).when(bookRepositoryMock).findAll();
    List<BookEntity> result = target.getAllBooks();
    assertAll("result", () -> {
      assertThat(result.size(), equalTo(0));
      verify(bookRepositoryMock).findAll();
    });
  }

  //Sapient generated method id: ${2284fc3d-473b-3992-886d-8fe431bd702d}
  @Test()
  void createTest() {
    BookRepository bookRepositoryMock = mock(BookRepository.class);
    BookServiceImpl target = new BookServiceImpl(bookRepositoryMock);
    BookEntity bookEntity = new BookEntity();
    doReturn(bookEntity).when(bookRepositoryMock).save((BookEntity) any());
    BookDto bookDto = new BookDto();
    bookDto.setAuthor("author1");
    bookDto.setPrice(0);
    bookDto.setName("name1");
    BookEntity result = target.create(bookDto);
    assertAll("result", () -> {
      assertThat(result, equalTo(bookEntity));
      verify(bookRepositoryMock).save((BookEntity) any());
    });
  }


}
