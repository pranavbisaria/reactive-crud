package com.bookStore.controller;

import com.bookStore.payload.request.CreateBookRequest;
import com.bookStore.payload.request.UpdateBookRequest;
import com.bookStore.payload.response.BookResponse;
import com.bookStore.service.BookService;
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
    public ResponseEntity<Flux<BookResponse>> create(@RequestBody Flux<CreateBookRequest> createBookRequest) {
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
    public ResponseEntity<Mono<BookResponse>> update(@RequestBody UpdateBookRequest request) {
        return ResponseEntity.ok(this.bookService.updateBook(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable Long id){
        return ResponseEntity.ok(this.bookService.deleteBook(id));
    }
}
