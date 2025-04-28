package com.crud.library.service;

import com.crud.library.dto.BookDto;

import java.util.List;

public interface IBookService {
    BookDto save(BookDto bookDto);

    BookDto update(BookDto bookDto);

    void delete(Long bookId);

    BookDto getById(Long bookId);

    List<BookDto> getAll();
}
