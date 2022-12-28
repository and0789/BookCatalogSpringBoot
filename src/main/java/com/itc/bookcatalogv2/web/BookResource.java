package com.itc.bookcatalogv2.web;

import com.itc.bookcatalogv2.dto.BookDetailDTO;
import com.itc.bookcatalogv2.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // fitur logging, untuk memberikan keterangan log pada sebuah proses (untuk membantu proses debuging)
@AllArgsConstructor
@RestController
public class BookResource {

    private final BookService bookService;

    @GetMapping("/book/{bookId}")
    public BookDetailDTO findBookDetail(@PathVariable("bookId") Long id) {
        StopWatch stopWatch = new StopWatch();
        log.info("Start findBookDetail" + id); // fitur loger
        stopWatch.start();
        BookDetailDTO result =  bookService.findBookDetailById(id);
        log.info("finish findBookDetail, execution time = {}", stopWatch.getTotalTimeMillis()); // fitur loger
        return result;
    }
}
