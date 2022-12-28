package com.itc.bookcatalogv2.repository.impl;

import com.itc.bookcatalogv2.domain.Book;
import com.itc.bookcatalogv2.repository.BookRepository;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class BookRepositoryImpl implements BookRepository {

    private Map<Long, Book> bookMap;
    @Override
    public Book findBookById(Long id) {
        Book book = bookMap.get(id);
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>(bookMap.values());
        return bookList;
    }

    @Override
    public void save(Book book) {
        int size = bookMap.size();
        book.setId((long) size + 1);
        bookMap.put(book.getId(), book);
    }

}
