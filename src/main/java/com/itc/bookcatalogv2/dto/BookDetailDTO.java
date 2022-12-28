package com.itc.bookcatalogv2.dto;

import lombok.Data;

@Data
public class BookDetailDTO {
    private Long bookId;
    private String authorName;
    private String bookTitle;
    private String bookDescription;

}
