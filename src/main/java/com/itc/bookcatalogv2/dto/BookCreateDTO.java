package com.itc.bookcatalogv2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookCreateDTO {

    @NotBlank
    private String bookTitle;

    @NotBlank
    private String authorName;

    private String bookDescription;

}
