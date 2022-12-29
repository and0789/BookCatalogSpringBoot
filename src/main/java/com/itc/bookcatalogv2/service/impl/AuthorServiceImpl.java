package com.itc.bookcatalogv2.service.impl;

import com.itc.bookcatalogv2.domain.Author;
import com.itc.bookcatalogv2.dto.AuthorCreateRequestDTO;
import com.itc.bookcatalogv2.dto.AuthorResponseDTO;
import com.itc.bookcatalogv2.dto.AuthorUpdateRequestDTO;
import com.itc.bookcatalogv2.exceptions.BadRequestExceptions;
import com.itc.bookcatalogv2.repository.AuthorRepository;
import com.itc.bookcatalogv2.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findAuthorById(Long id) {

        // Fetch data from database
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new BadRequestExceptions("Invalid.authorDI"));

        // parsing kedalam author  author -> authorResponsDTO
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorName(author.getName());
        dto.setBirthDate(author.getBirthDate().toEpochDay());

        return dto;
    }

//    @Override
//    public void createNewAuthor(AuthorCreateRequestDTO dto) {
//
//        Author author = new Author();
//        author.setName(dto.getAuthorName());
//        author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
//
//        authorRepository.save(author);
//    }

    @Override
    public void createNewAuthor(List<AuthorCreateRequestDTO> dtos) {

        List<Author> authors = dtos.stream().map((dto) -> {
            Author author = new Author();
            author.setName(dto.getAuthorName());
            author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
            return author;
        }).collect(Collectors.toList());

        authorRepository.saveAll(authors);
    }

    @Override
    public void updateAuthor(Long authorId, AuthorUpdateRequestDTO dto) {
        // find data author
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new BadRequestExceptions("Invalid.authorDI"));
        author.setName(dto.getAuthorName() == null ?
                author.getName() : dto.getAuthorName());
        author.setBirthDate(dto.getBirthDate() == null ?
                author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));

        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        // select terlebih dahulu ada atau tidak, jika ada baru bisa delete
        // delete secara langsung (hard delete)
        authorRepository.deleteById(authorId);


//        // Soft delete
//        // select data deleted=false
//        Author author = authorRepository.findByIdAndDeletedFalse(authorId)
//                .orElseThrow(() -> new BadRequestExceptions("Invalid.authorId"));
//
//        // select data deleted=ture
//        author.setDeleted(Boolean.TRUE);
//        authorRepository.save(author);
    }
}
