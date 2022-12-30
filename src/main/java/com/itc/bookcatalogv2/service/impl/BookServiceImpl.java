package com.itc.bookcatalogv2.service.impl;

import com.itc.bookcatalogv2.domain.Author;
import com.itc.bookcatalogv2.domain.Book;
import com.itc.bookcatalogv2.domain.Category;
import com.itc.bookcatalogv2.domain.Publisher;
import com.itc.bookcatalogv2.dto.BookCreateRequestDTO;
import com.itc.bookcatalogv2.dto.BookDetailResponseDTO;
import com.itc.bookcatalogv2.dto.BookUpdateRequestDTO;
import com.itc.bookcatalogv2.exceptions.BadRequestExceptions;
import com.itc.bookcatalogv2.repository.BookRepository;
import com.itc.bookcatalogv2.service.AuthorService;
import com.itc.bookcatalogv2.service.BookService;
import com.itc.bookcatalogv2.service.CategoryService;
import com.itc.bookcatalogv2.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorService authorService;

    private final CategoryService categoryService;

    private final PublisherService publisherService;


    @Override
    public BookDetailResponseDTO findBookDetailById(String bookId) {
        Book book = bookRepository.findBySecureId(bookId)
                .orElseThrow(() -> new BadRequestExceptions("book_id.invalid"));

        BookDetailResponseDTO dto = new BookDetailResponseDTO();
        dto.setBookId(book.getSecureId());
        dto.setCategories(categoryService.constructDTO(book.getCategories()));
        dto.setAuthors(authorService.constructDTO(book.getAuthors()));
        dto.setPublisher(publisherService.constructDTO(book.getPublisher()));
        dto.setBookTitle(book.getTitle());
        dto.setBookDescription(book.getDescription());

        return dto;
    }

    @Override
    public List<BookDetailResponseDTO> findBookListDetail() {
        return null;
    }

    @Override
    public void createNewBook(BookCreateRequestDTO dto) {
        List<Author> authors = authorService.findAuthors(dto.getAuthorIdList());
        List<Category> categories = categoryService.findCategories(dto.getCategoryList());
        Publisher publisher = publisherService.findPublisher(dto.getPublisherId());

        Book book = new Book();
        book.setAuthors(authors);
        book.setCategories(categories);
        book.setPublisher(publisher);
        book.setTitle(dto.getBookTitle());
        book.setDescription(dto.getBookDescription());

        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long bookId, BookUpdateRequestDTO dto) {

    }

    @Override
    public void deleteBook(Long bookId) {

    }


}
