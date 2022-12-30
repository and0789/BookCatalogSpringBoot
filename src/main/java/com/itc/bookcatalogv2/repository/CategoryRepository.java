package com.itc.bookcatalogv2.repository;

import com.itc.bookcatalogv2.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByCode(String code);

    Page<Category> findByNameLikeIgnoreCase(String categoryName, Pageable pageable);
}
