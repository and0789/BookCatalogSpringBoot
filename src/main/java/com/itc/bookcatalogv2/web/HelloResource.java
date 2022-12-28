package com.itc.bookcatalogv2.web;

import com.itc.bookcatalogv2.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    private final GreetingService greetingService;


    public HelloResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return greetingService.sayGreeting();
    }

}
