package com.crud.library.service.impl;

import com.crud.library.dto.BookDto;
import com.crud.library.entity.Book;
import com.crud.library.repository.BookRepository;
import com.crud.library.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public BookDto save(BookDto bookDto) {
        Book map = modelMapper.map(bookDto, Book.class);
        Book book = bookRepository.saveAndFlush(map);
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public BookDto update(BookDto bookDto) {
        if (bookDto.getId() == null) {
            throw new RuntimeException("Book ID is required for update.");
        }
       Book existingBook = bookRepository.findById(bookDto.getId()).orElseThrow(() -> new RuntimeException("Book not found with id: " + bookDto.getId()));
        modelMapper.map(bookDto, existingBook); //update
        Book updatedBook = bookRepository.saveAndFlush(existingBook);
        return modelMapper.map(updatedBook, BookDto.class);
    }

    @Override
    public void delete(Long bookId) {
        if(!bookRepository.existsById(bookId)){
            throw new RuntimeException("Book not found with id: " + bookId);
        }
        bookRepository.deleteById(bookId);
    }


    @Override
    public BookDto getById(Long bookId) {
        Optional<Book> byId = bookRepository.findById(bookId);
        return byId.map(book -> modelMapper.map(book, BookDto.class)).orElseThrow(()-> new RuntimeException("Book not found with id:" + bookId));
    }

    @Override
    public List<BookDto> getAll(){
        List<Book> all = bookRepository.findAll();
        return all.stream().map( id -> modelMapper.map(id, BookDto.class)).toList();
    }
}
