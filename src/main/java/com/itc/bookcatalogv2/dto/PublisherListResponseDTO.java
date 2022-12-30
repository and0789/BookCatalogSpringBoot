package com.itc.bookcatalogv2.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherListResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6563391983236205909L;

    private String publisherId;
    private String publisherName;
    private String companyName;


}
