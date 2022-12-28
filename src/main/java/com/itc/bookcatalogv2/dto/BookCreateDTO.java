package com.itc.bookcatalogv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) //untuk penamaan di json menjadi seperti ini book_title, author_name
public class BookCreateDTO {

    @NotBlank
    private String bookTitle;

    @NotBlank
    private String authorName;

    // @JsonProperty("synopsis") //untuk penamaan di json supaya bisa jadi synopsis
    private String bookDescription;

}
