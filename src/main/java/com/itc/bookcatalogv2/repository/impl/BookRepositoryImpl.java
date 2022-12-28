package com.itc.bookcatalogv2.repository.impl;

import com.itc.bookcatalogv2.domain.Book;
import com.itc.bookcatalogv2.repository.BookRepository;
import lombok.Data;

import java.util.Map;

@Data
public class BookRepositoryImpl implements BookRepository {

    private Map<Long, Book> bookMap;
    @Override
    public Book findBookById(Long id) {
        Book book = bookMap.get(id);
        return book;
    }

}
