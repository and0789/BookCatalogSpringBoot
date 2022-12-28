package com.itc.bookcatalogv2.service;

import com.itc.bookcatalogv2.dto.BookDetailDTO;

public interface BookService {
    BookDetailDTO findBookDetailById(Long bookId);
}
