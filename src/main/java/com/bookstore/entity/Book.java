package com.bookstore.entity;

import com.bookstore.payload.response.BookResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private Long bookId;
    private String title;
    private String author;
    private int year;
    private double price;
    private String description;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Book(String title, String author, int year, double price, String description) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.description = description;
    }

    public BookResponse mapBookResponse() {
        return new BookResponse(
            this.bookId,
            this.title,
            this.author,
            this.year,
            this.price,
            this.description
        );
    }
}
