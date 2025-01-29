package com.samhith.books_store.mapper;

import com.samhith.books_store.dto.BookDto;
import com.samhith.books_store.entity.Book;

public class BookMapper {

    public static BookDto toDto(Book book){
        BookDto bookDto = new BookDto(book.bookId(), book.name(), book.price(), book.author(), book.description());
        return bookDto;
    }

    public static Book toEntity(BookDto bookDto){
        Book book = new Book(bookDto.bookId(), bookDto.name(), bookDto.price(), bookDto.author(), bookDto.description());
        return book;
    }
}
