package com.bookstore.payload.request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

public record UpdateBookRequest (
        @NotNull(message = "Book ID cannot be null")
        @Positive(message = "Book ID must be positive")
        Long bookId,
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
    public UpdateBookRequest {
        title = title.trim();
        author = author.trim();
    }
}
