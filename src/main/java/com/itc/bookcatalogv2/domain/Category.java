package com.itc.bookcatalogv2.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category extends AbstractBaseEntity {


    @Serial
    private static final long serialVersionUID = -3320113658200842946L;
    @Id
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "categories") // many to many bidirectional
    private List<Book> books;
}
