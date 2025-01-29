package com.samhith.books_store.controller;

import com.samhith.books_store.dto.BookDto;
import com.samhith.books_store.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-store")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //Add crud operations
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable String bookId){
        BookDto bookDto = bookService.getBook(bookId);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }


    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> bookDtoList = bookService.getAllBooks();
        return new ResponseEntity<>(bookDtoList, HttpStatus.OK);
    }

//    create books
    @PostMapping("/")
    public ResponseEntity<BookDto> createBooks(@RequestBody BookDto bookDto){
        BookDto bookDto1 = bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }

//    @PostMapping("/")
//    public ResponseEntity<List<BookDto>> createBooks(@RequestBody List<BookDto> bookDtos) {
//        List<BookDto> createdBooks = bookService.createBooks(bookDtos);
//        return new ResponseEntity<>(createdBooks, HttpStatus.CREATED);
//    }



    @PutMapping("/")
    public ResponseEntity<BookDto> updateBooks(@RequestBody BookDto bookDto){
        BookDto bookDto1 = bookService.updateBookName(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId){
        bookService.deleteBookByBookId(bookId);
        return new ResponseEntity<>("Book Deleted Successfully "+ bookId, HttpStatus.OK);
    }

}
