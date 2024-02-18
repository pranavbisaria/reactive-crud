package com.bookStore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GeneralController {
    @GetMapping
    public Mono<String> home() {
        return Mono.just("Working SuccessFully!!");
    }
}
