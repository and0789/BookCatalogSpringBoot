package com.itc.bookcatalogv2.web;

import com.itc.bookcatalogv2.dto.BookCreateRequestDTO;
import com.itc.bookcatalogv2.dto.BookDetailResponseDTO;
import com.itc.bookcatalogv2.dto.BookUpdateRequestDTO;
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

    @GetMapping("/v1/book/{bookId}")
    public ResponseEntity<BookDetailResponseDTO> findBookDetail(@PathVariable("bookId") String id) {
        StopWatch stopWatch = new StopWatch();
        log.info("Start findBookDetail" + id); // fitur loger
        stopWatch.start();
        BookDetailResponseDTO result = bookService.findBookDetailById(id);
        log.info("finish findBookDetail, execution time = {}", stopWatch.getTotalTimeMillis()); // fitur loger
        return ResponseEntity.ok(result);
    }

    @PostMapping("/v1/book")
    public ResponseEntity<Void> createNewBook(@RequestBody BookCreateRequestDTO dto) {
        bookService.createNewBook(dto);
        return ResponseEntity.created(URI.create("/v1/book")).build();
    }

    @GetMapping("/v1/book")
    public ResponseEntity<List<BookDetailResponseDTO>> findBookList() {
        return ResponseEntity.ok().body(bookService.findBookListDetail());
    }

    @PutMapping("/v1/book/{bookId}")
    public ResponseEntity<Void> updateBook(
            @PathVariable("bookId")
            Long bookId,
            @RequestBody BookUpdateRequestDTO dto) {
        bookService.updateBook(bookId, dto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
