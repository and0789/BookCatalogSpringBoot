package com.itc.bookcatalogv2.web;

import com.itc.bookcatalogv2.dto.BookCreateDTO;
import com.itc.bookcatalogv2.dto.BookDetailDTO;
import com.itc.bookcatalogv2.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @PostMapping("/book")
    public ResponseEntity<Void> createNewBook(@RequestBody BookCreateDTO dto) {
        bookService.createNewBook(dto);
        return ResponseEntity.created(URI.create("/book")).build();
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookDetailDTO>> findBookList() {
        return ResponseEntity.ok().body(bookService.findBookListDetail());
    }
}
