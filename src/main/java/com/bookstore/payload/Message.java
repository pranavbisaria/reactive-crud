package com.bookstore.payload;

public record Message (
    String message,
    int status
){}
