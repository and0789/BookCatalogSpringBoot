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
    public AuthorResponseDTO findAuthorById(String id) {
        // TODO Auto-generated method stub
        // 1. fetch data from databse
        Author author = authorRepository.findBySecureId(id)
                .orElseThrow(() -> new BadRequestExceptions("invalid.authorId"));
        // 2. author -> authorResponseDTO
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorName(author.getName());
        dto.setBirthDate(author.getBirthDate().toEpochDay());
        return dto;
    }

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
    public void updateAuthor(String authorId, AuthorUpdateRequestDTO dto) {
        Author author = authorRepository.findBySecureId(authorId)
                .orElseThrow(() -> new BadRequestExceptions("invalid.authorId"));
        author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
        author.setBirthDate(
                dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));

        authorRepository.save(author);

    }

    // oracle db -> flashback technologies
    // softdelete
    @Override
    public void deleteAuthor(String authorId) {
        // 1 select data
        // 2 delete
        // or
        // 1 delete (harddelete)
//		authorRepository.deleteById(authorId);
        Author author = authorRepository.findBySecureId(authorId)
                .orElseThrow(() -> new BadRequestExceptions("invalid.authorId"));
        authorRepository.delete(author);
        // softdelete
        // 1. select data deleted=false
//		Author author = authorRepository.findByIdAndDeletedFalse(authorId)
//				.orElseThrow(() -> new BadRequestException("invalid.authorId"));
//
//		// 2. update deleted=true
//		author.setDeleted(Boolean.TRUE);
//		authorRepository.save(author);
    }

    @Override
    public List<Author> findAuthors(List<String> authorIdList) {
        List<Author> authors = authorRepository.findBySecureIdIn(authorIdList);
        if (authors.isEmpty())
            throw new BadRequestExceptions("author cant empty");
        return authors;
    }

    @Override
    public List<AuthorResponseDTO> constructDTO(List<Author> authors) {
        return authors.stream().map((a)->{
            AuthorResponseDTO dto = new AuthorResponseDTO();
            dto.setAuthorName(a.getName());
            dto.setBirthDate(a.getBirthDate().toEpochDay());
            return dto;
        }).collect(Collectors.toList());
    }
}
