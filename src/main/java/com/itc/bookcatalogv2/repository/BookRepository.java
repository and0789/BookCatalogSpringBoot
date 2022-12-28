package com.itc.bookcatalogv2.repository;

import com.itc.bookcatalogv2.domain.Book;

import java.util.List;

public interface BookRepository {
    public Book findBookById(Long id);

    public List<Book> findAll();

    public void save(Book book);
}
