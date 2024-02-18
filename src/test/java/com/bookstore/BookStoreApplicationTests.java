package com.bookstore;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class BookStoreApplicationTests {
	@Autowired
	private BookRepository  bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void findMethodTest() {
		Flux<Book> book = this.bookRepository.findByTitle("Moby-Dick");
		StepVerifier.create(book).expectNextCount(2).verifyComplete();
	}

	@Test
	void findByTitleTest() {
		this.bookRepository.findAllByTitleContainingIgnoreCase("MOBY-dick").as(StepVerifier::create)
				.expectNextCount(2).verifyComplete();
	}

	@Test
	void findByCustomQuery() {
		this.bookRepository.lastTenLatestBook().as(StepVerifier::create)
				.expectNextCount(10).verifyComplete();
	}
}
