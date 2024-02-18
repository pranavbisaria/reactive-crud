package com.bookStore.service;

import com.bookStore.payload.request.CreateBookRequest;
import com.bookStore.payload.request.UpdateBookRequest;
import com.bookStore.payload.response.BookResponse;
import org.springframework.stereotype.Service;
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
