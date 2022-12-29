package com.itc.bookcatalogv2.service;

import com.itc.bookcatalogv2.dto.BookCreateDTO;
import com.itc.bookcatalogv2.dto.BookDetailDTO;
import com.itc.bookcatalogv2.dto.BookUpdateRequestDTO;

import java.util.List;

public interface BookService {
    public BookDetailDTO findBookDetailById(Long bookId);

    public List<BookDetailDTO> findBookListDetail();

    public void createNewBook(BookCreateDTO dto);

    public void updateBook(Long bookId, BookUpdateRequestDTO dto);

    public void deleteBook(Long bookId);

}
