package com.itc.bookcatalogv2.repository;

import com.itc.bookcatalogv2.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Query method name convention
    // find+keyword


    // sql --> select * from author a where a.id= :authorId
    // public Optional<Author>findById(Long id);


    // where id= :id And deleted=false
    Optional<Author> findByIdAndDeletedFalse(Long id);

    // sql --> select a from Author a where a.name LIKE :authorId
    List<Author> findByNameLike(String authorName);

}
