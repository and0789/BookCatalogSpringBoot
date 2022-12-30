package com.itc.bookcatalogv2.service;

import com.itc.bookcatalogv2.domain.Author;
import com.itc.bookcatalogv2.dto.AuthorCreateRequestDTO;
import com.itc.bookcatalogv2.dto.AuthorResponseDTO;
import com.itc.bookcatalogv2.dto.AuthorUpdateRequestDTO;

import java.util.List;

public interface AuthorService {
    public AuthorResponseDTO findAuthorById(String id);

    public void createNewAuthor(List<AuthorCreateRequestDTO> dto);

    public void updateAuthor(String authorId, AuthorUpdateRequestDTO dto);

    public void deleteAuthor(String authorId);

    public List<Author> findAuthors(List<String> authorIdList);

    public List<AuthorResponseDTO> constructDTO(List<Author> authors);
}
