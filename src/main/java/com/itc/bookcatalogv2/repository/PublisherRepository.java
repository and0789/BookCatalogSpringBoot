package com.itc.bookcatalogv2.repository;

import com.itc.bookcatalogv2.domain.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Optional<Publisher> findBySecureId(String secureId);

    Page<Publisher> findByNameLikeIgnoreCase(String publisherName, Pageable pageable);
}
