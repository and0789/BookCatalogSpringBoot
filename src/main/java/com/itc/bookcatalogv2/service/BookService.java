package com.itc.bookcatalogv2.service;

import com.itc.bookcatalogv2.dto.BookCreateRequestDTO;
import com.itc.bookcatalogv2.dto.BookDetailResponseDTO;
import com.itc.bookcatalogv2.dto.BookUpdateRequestDTO;

import java.util.List;

public interface BookService {
    BookDetailResponseDTO findBookDetailById(String bookId);

    List<BookDetailResponseDTO> findBookListDetail();

    void createNewBook(BookCreateRequestDTO dto);

    public void updateBook(Long bookId, BookUpdateRequestDTO dto);

    public void deleteBook(Long bookId);

}
