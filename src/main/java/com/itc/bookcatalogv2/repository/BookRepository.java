package com.itc.bookcatalogv2.repository;

import com.itc.bookcatalogv2.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {


    Optional<Book> findById(Long id);

    Optional<Book> findBySecureId(String id);
//
//    public List<Book> findAll();
//
//    public void save(Book book);
//
//    public void update(Book book);
//
//    public void delete(Long bookId);
}
