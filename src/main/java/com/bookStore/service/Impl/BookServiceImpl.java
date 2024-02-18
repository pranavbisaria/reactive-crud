package com.bookStore.service.Impl;

import com.bookStore.entity.Book;
import com.bookStore.payload.request.CreateBookRequest;
import com.bookStore.payload.request.UpdateBookRequest;
import com.bookStore.payload.response.BookResponse;
import com.bookStore.repository.BookRepository;
import com.bookStore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @Override
    public Flux<BookResponse> findAll() {
        return this.bookRepository.findAll().map(Book::mapBookResponse);
    }

    @Override
    public Flux<BookResponse> findAllByTitle(String title) {
        return this.bookRepository.findAllByTitleContainingIgnoreCase(title).map(Book::mapBookResponse);
    }
}
