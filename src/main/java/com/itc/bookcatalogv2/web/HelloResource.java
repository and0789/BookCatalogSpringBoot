package com.itc.bookcatalogv2.web;

import com.itc.bookcatalogv2.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    Logger log = LoggerFactory.getLogger(HelloResource.class);

    private final GreetingService greetingService;


    public HelloResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        log.trace("this is log TRACE");
        log.debug("this is log DEBUG");
        log.info("this is log INFO");
        log.warn("this is log WARN");
        log.error("this is log ERROR");

        return greetingService.sayGreeting();
    }

}
