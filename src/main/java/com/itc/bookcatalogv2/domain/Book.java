package com.itc.bookcatalogv2.domain;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private String description;
    private Author author;

}
