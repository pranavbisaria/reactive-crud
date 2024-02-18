package com.bookstore.payload.response;

public record BookResponse (
    Long bookId,
    String title,
    String author,
    int year,
    double price,
    String description
){}
