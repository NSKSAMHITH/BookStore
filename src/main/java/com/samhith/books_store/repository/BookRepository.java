package com.samhith.books_store.repository;

import com.samhith.books_store.entity.Book;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

public interface BookRepository extends MongoRepository<Book, String> {

    //find the book By id
    @Query("{bookId : '?0'}")
    Book findBookByBookId(String bookId);

    //update a specific field in book
    @Query(value = "{ 'bookId' : { $eq: ?0}}")
    @Update(pipeline = {"{ '$set' : { 'name' : ?1}}"})
    void updateBookNameByBookId(String bookId, String name);


    //delete book by BookId
    @DeleteQuery
    void deleteBookByBookId(String bookId);
}
