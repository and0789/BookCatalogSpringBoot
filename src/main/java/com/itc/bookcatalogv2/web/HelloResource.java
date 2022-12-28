package com.itc.bookcatalogv2.web;

import com.itc.bookcatalogv2.dto.HelloMessageResponseDTO;
import com.itc.bookcatalogv2.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    Logger log = LoggerFactory.getLogger(HelloResource.class);

    private final GreetingService greetingService;


    public HelloResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    // get adalah salah satu jenis dari http method / http verb
    // POST, PUT, DELETE, OPTION, TRACE, HEAD, PATCh
    @GetMapping("/hello")
    public HelloMessageResponseDTO helloWorld() {
        log.trace("this is log TRACE");
        log.debug("this is log DEBUG");
        log.info("this is log INFO");
        log.warn("this is log WARN");
        log.error("this is log ERROR");
        HelloMessageResponseDTO dto = new HelloMessageResponseDTO();
        dto.setMessage(greetingService.sayGreeting());

        return dto;
    }

    @GetMapping("/helloResponseEntity")
    public ResponseEntity<HelloMessageResponseDTO> responseEntity() {
        HelloMessageResponseDTO dto = new HelloMessageResponseDTO();
        dto.setMessage(greetingService.sayGreeting());
        return ResponseEntity.accepted().body(dto);
    }

}
