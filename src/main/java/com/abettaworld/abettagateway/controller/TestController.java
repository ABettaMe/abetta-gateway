package com.abettaworld.abettagateway.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;


@RestController
@RequestMapping("/test-controller")
public class TestController {

    @CrossOrigin
    @GetMapping
    public Mono<String> testController(Principal principal) {
        return Mono.just("<h1>test controller response!</h1>");
    }
}
