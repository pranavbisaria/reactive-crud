package com.bookstore.controller;

import com.bookstore.payload.request.CreateBookRequest;
import com.bookstore.payload.request.UpdateBookRequest;
import com.bookstore.payload.response.BookResponse;
import com.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Flux<BookResponse>> create(@Valid @RequestBody Flux<CreateBookRequest> createBookRequest) {
        return ResponseEntity.ok(this.bookService.createBook(createBookRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<BookResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.bookService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Flux<BookResponse>> getAll() {
        return ResponseEntity.ok(this.bookService.findAll());
    }

    @PutMapping
    public ResponseEntity<Mono<BookResponse>> update(@Valid @RequestBody UpdateBookRequest request) {
        return ResponseEntity.ok(this.bookService.updateBook(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable Long id){
        return ResponseEntity.ok(this.bookService.deleteBook(id));
    }

    @GetMapping("/byTitle")
    public ResponseEntity<Flux<BookResponse>> searchByTitle(@RequestParam String query) {
        return ResponseEntity.ok(this.bookService.findAllByTitle(query));
    }
}
