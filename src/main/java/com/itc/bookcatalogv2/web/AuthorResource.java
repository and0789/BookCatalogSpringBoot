package com.itc.bookcatalogv2.web;

import com.itc.bookcatalogv2.dto.AuthorCreateRequestDTO;
import com.itc.bookcatalogv2.dto.AuthorResponseDTO;
import com.itc.bookcatalogv2.dto.AuthorUpdateRequestDTO;
import com.itc.bookcatalogv2.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorResource {

    private final AuthorService authorService;

    //author detail
    @GetMapping("/v1/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> findAuthorById(@PathVariable String id){
        return ResponseEntity.ok().body(authorService.findAuthorById(id));
    }

    @PostMapping("/v1/author")
    public ResponseEntity<Void> createNewAuthor(@RequestBody @Valid List<AuthorCreateRequestDTO> dto){
        authorService.createNewAuthor(dto);
        return ResponseEntity.created(URI.create("/author")).build();
    }


    @PutMapping("/v1/author/{authorId}")
    public ResponseEntity<Void> updateAuthor(@PathVariable String authorId,
                                             @RequestBody AuthorUpdateRequestDTO dto){
        authorService.updateAuthor(authorId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/author/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable String authorId){
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().build();
    }
}
