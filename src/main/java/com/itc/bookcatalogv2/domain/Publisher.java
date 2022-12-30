package com.itc.bookcatalogv2.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.util.List;
import java.util.UUID;


@Data
@Entity
@Table(name = "publisher")
public class Publisher extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = 1201014546412953581L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
    @SequenceGenerator(name = "publisher_generator", sequenceName = "publisher_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "address")
    private String address;

    // Opsional bila menginginkan relais dua arah / bidirectional relation
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    @Column(name = "secure_id", nullable = false, unique = true)
    private String secureId = UUID.randomUUID().toString();


}
