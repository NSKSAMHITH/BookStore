package com.samhith.books_store.dto;

//Data trnasfer object
public record BookDto(String bookId, String name, String price, String author, String description) {
}
