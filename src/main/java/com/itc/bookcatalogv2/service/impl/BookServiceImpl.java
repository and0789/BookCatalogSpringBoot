package com.itc.bookcatalogv2.service.impl;

import com.itc.bookcatalogv2.domain.Book;
import com.itc.bookcatalogv2.dto.BookDetailDTO;
import com.itc.bookcatalogv2.repository.BookRepository;
import com.itc.bookcatalogv2.service.BookService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookDetailDTO findBookDetailById(Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        BookDetailDTO dto = new BookDetailDTO();
        dto.setId(book.getId());
        dto.setAuthorName(book.getAuthor().getName());
        dto.setBookTitle(book.getTitle());
        dto.setBookDescription(book.getDescription());
        return dto;
    }

}
