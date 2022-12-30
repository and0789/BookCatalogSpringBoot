package com.itc.bookcatalogv2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Index;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
@Table(indexes = {
        @Index(name="uk_secure_id", columnList = "secure_id")
})
public abstract class AbstractBaseEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 7584755938498099063L;

    @Column(name = "secure_id", nullable = false, unique = true)
    private String secureId=UUID.randomUUID().toString();

    @Column(name="deleted", columnDefinition = "boolean default false")
    private boolean deleted;

}
