package com.bookstore.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Long bookId;
    private String title;
    private String author;
    private int year;
    private double price;
    private String description;
}
