package com.bookstore.payload.request;

public record UpdateBookRequest (
        Long bookId,
        String title,
        String author,
        int year,
        double price,
        String description
){
    public UpdateBookRequest {
        title = title.trim();
        author = author.trim();
    }
}
