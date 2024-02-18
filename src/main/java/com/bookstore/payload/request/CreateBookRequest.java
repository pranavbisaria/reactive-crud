package com.bookstore.payload.request;

import com.bookstore.entity.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public record CreateBookRequest (
        @NotBlank(message = "Title can not be empty")
        @Size(max = 100, message = "Title must be less than 100 characters")
        String title,
        @NotBlank(message = "Author can not be empty")
        @Size(max = 100, message = "Author must be less than 100 characters")
        String author,
        @Range(min = 1000, max = 3000, message = "Please enter a valid year")
        int year,
        @PositiveOrZero(message = "Price must be non-negative")
        double price,
        @Size(max = 500, message = "Description must be less than 500 characters")
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