package com.bookStore.payload.request;

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
}
