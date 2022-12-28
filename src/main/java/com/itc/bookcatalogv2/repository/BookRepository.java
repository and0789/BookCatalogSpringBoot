package com.itc.bookcatalogv2.repository;

import com.itc.bookcatalogv2.domain.Book;

public interface BookRepository {
    public Book findBookById(Long id);
}
