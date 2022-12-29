package com.itc.bookcatalogv2.config;

import com.itc.bookcatalogv2.domain.Author;
import com.itc.bookcatalogv2.domain.Book;
import com.itc.bookcatalogv2.repository.BookRepository;
import com.itc.bookcatalogv2.repository.impl.BookRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public Author author() {
        return new Author(1L, "Andre Septian", null, false);
    }

    @Bean
    public Book book1(Author author) {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Java Programing");
        book.setDescription("The best book for java programing");
        book.setAuthor(author);
        return book;
    }

    @Bean
    public Book book2(Author author) {
        Book book = new Book();
        book.setId(2L);
        book.setTitle("Full Stack Programing");
        book.setDescription("The best book for full stack developer");
        book.setAuthor(author);
        return book;
    }


    @Bean
    public BookRepository bookRepository(Book book1, Book book2) {
        Map<Long, Book> bookMap = new HashMap<Long, Book>();
        bookMap.put(1L, book1);
        bookMap.put(2L, book2);

        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        bookRepository.setBookMap(bookMap);

        return bookRepository;
    }

}
