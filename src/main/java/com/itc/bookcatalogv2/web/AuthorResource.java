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

    @GetMapping("/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> findAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok().body(authorService.findAuthorById(id));
    }

//    @PostMapping("/author")
//    public ResponseEntity<Void> createNewAuthor(@RequestBody @Valid AuthorCreateRequestDTO dto){
//        authorService.createNewAuthor(dto);
//        return ResponseEntity.created(URI.create("/author")).build();
//    }

    @PostMapping("/author")
    public ResponseEntity<Void> createNewAuthor(@RequestBody @Valid List<AuthorCreateRequestDTO> dto) {
        authorService.createNewAuthor(dto);
        return ResponseEntity.created(URI.create("/author")).build();
    }

    @PutMapping("/author/{authorId}")
    public ResponseEntity<Void> updateAuthor(@PathVariable Long authorId,
                                             @RequestBody AuthorUpdateRequestDTO dto) {
        authorService.updateAuthor(authorId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/author/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().build();
    }
}
