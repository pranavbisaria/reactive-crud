package com.bookstore.repository;

import com.bookstore.entity.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
    Flux<Book> findAllByTitleContainingIgnoreCase(String titleKeyword);

    Flux<Book> findByTitle(String title);

    @Query("select b.* from book b order by b.year limit 10")
    Flux<Book> lastTenLatestBook();
}
