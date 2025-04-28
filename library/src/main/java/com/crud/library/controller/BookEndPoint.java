package com.crud.library.controller;

import com.crud.library.dto.BookDto;
import com.crud.library.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("book")
@RequiredArgsConstructor
public class BookEndPoint {


    private final IBookService bookService;

    @PostMapping("/")
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto){
        BookDto response = bookService.save(bookDto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookDto> update(@PathVariable("bookId") Long bookId, @RequestBody BookDto bookDto){
        bookDto.setId(bookId);
       BookDto response = bookService.update(bookDto);
       return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> delete(@PathVariable("bookId") Long bookId){
        bookService.delete(bookId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getById(@PathVariable("bookId") Long bookId){
        BookDto byId = bookService.getById(bookId);
        return ResponseEntity.ok(byId);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAll(){
        List<BookDto> all = bookService.getAll();
        return ResponseEntity.ok(all);
    }
}

