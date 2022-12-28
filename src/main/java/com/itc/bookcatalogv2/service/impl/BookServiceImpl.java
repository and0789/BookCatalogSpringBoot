package com.itc.bookcatalogv2.service.impl;

import com.itc.bookcatalogv2.domain.Author;
import com.itc.bookcatalogv2.domain.Book;
import com.itc.bookcatalogv2.dto.BookCreateDTO;
import com.itc.bookcatalogv2.dto.BookDetailDTO;
import com.itc.bookcatalogv2.repository.BookRepository;
import com.itc.bookcatalogv2.service.BookService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @Override
    public BookDetailDTO findBookDetailById(Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        BookDetailDTO dto = new BookDetailDTO();
        dto.setBookId(book.getId());
        dto.setAuthorName(book.getAuthor().getName());
        dto.setBookTitle(book.getTitle());
        dto.setBookDescription(book.getDescription());
        return dto;
    }

    @Override
    public List<BookDetailDTO> findBookListDetail() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map((b) -> {
            BookDetailDTO dto = new BookDetailDTO();
            dto.setAuthorName(b.getAuthor().getName());
            dto.setBookDescription(b.getDescription());
            dto.setBookId(b.getId());
            dto.setBookTitle(b.getTitle());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void createNewBook(BookCreateDTO dto) {
        Author author = new Author();
        author.setName(dto.getAuthorName());

        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(dto.getBookTitle());
        book.setDescription(dto.getBookDescription());
        bookRepository.save(book);
    }

}
