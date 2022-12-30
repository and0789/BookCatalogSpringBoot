package com.itc.bookcatalogv2.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookDetailResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2419415099007897594L;

    private String bookId;

    private List<AuthorResponseDTO> authors;

    private List<CategoryListResponseDTO> categories;

    private PublisherResponseDTO publisher;

    private String bookTitle;

    private String bookDescription;

}
