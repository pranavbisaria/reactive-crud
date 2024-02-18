package com.bookstore.service.impl;

import com.bookstore.entity.Book;
import com.bookstore.payload.request.CreateBookRequest;
import com.bookstore.payload.request.UpdateBookRequest;
import com.bookstore.payload.response.BookResponse;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Flux<BookResponse> createBook(Flux<CreateBookRequest> book) {
        return this.bookRepository.saveAll(
                book.map(CreateBookRequest::toMapBook)
        ).map(Book::mapBookResponse);
    }

    @Override
    public Mono<BookResponse> updateBook(UpdateBookRequest request) {
        Mono<Book> oldBook = this.bookRepository.findById(request.bookId());

        return oldBook.flatMap(b -> {
            b.setTitle(request.title());
            b.setAuthor(request.author());
            b.setYear(request.year());
            b.setPrice(request.price());
            b.setDescription(request.description());
            return this.bookRepository.save(b);
        }).map(Book::mapBookResponse);
    }

    @Override
    public Mono<Void> deleteBook(Long id) {
        return this.bookRepository.deleteById(id);
    }

    @Override
    public Mono<BookResponse> findById(Long id) {
        return this.bookRepository.findById(id).map(Book::mapBookResponse);
    }

    // To illustrate the reactive fetch, I am using a delay of 2 seconds to show observable fetch
    @Override
    public Flux<BookResponse> findAll() {
        return this.bookRepository.findAll().map(Book::mapBookResponse).delayElements(Duration.ofMillis(2000));
    }

    @Override
    public Flux<BookResponse> findAllByTitle(String title) {
        return this.bookRepository.findAllByTitleContainingIgnoreCase(title).map(Book::mapBookResponse);
    }
}
