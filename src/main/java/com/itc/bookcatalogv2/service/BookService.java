package com.itc.bookcatalogv2.service;

import com.itc.bookcatalogv2.dto.BookCreateDTO;
import com.itc.bookcatalogv2.dto.BookDetailDTO;

import java.util.List;

public interface BookService {
    public BookDetailDTO findBookDetailById(Long bookId);

    public List<BookDetailDTO> findBookListDetail();

    public void createNewBook(BookCreateDTO dto);


}
