package com.itc.bookcatalogv2.service;

import com.itc.bookcatalogv2.dto.AuthorCreateRequestDTO;
import com.itc.bookcatalogv2.dto.AuthorResponseDTO;
import com.itc.bookcatalogv2.dto.AuthorUpdateRequestDTO;

import java.util.List;

public interface AuthorService {
    AuthorResponseDTO findAuthorById(Long id);

//    void createNewAuthor(AuthorCreateRequestDTO dto);

    void createNewAuthor(List<AuthorCreateRequestDTO> dto);

    void updateAuthor(Long authorId, AuthorUpdateRequestDTO dto);

    void deleteAuthor(Long authorId);
}
