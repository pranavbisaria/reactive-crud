package com.bookstore.service;

import com.bookstore.payload.request.CreateBookRequest;
import com.bookstore.payload.request.UpdateBookRequest;
import com.bookstore.payload.response.BookResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    Flux<BookResponse> createBook(Flux<CreateBookRequest> book);

    Mono<BookResponse> updateBook(UpdateBookRequest request);

    Mono<Void> deleteBook(Long id);

    Mono<BookResponse> findById(Long id);

    Flux<BookResponse> findAll();

    Flux<BookResponse> findAllByTitle(String title);
}
