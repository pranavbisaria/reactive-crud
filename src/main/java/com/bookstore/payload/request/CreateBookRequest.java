package com.bookstore.payload.request;

import com.bookstore.entity.Book;

public record CreateBookRequest (
        String title,
        String author,
        int year,
        double price,
        String description
){
    public CreateBookRequest {
        title = title.trim();
        author = author.trim();
   }

   public Book toMapBook() {
        return new Book(title, author, year, price, description);
   }
}
