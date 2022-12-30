package com.itc.bookcatalogv2.service;

import com.itc.bookcatalogv2.dto.PublisherCreateRequestDTO;
import com.itc.bookcatalogv2.dto.PublisherListResponseDTO;
import com.itc.bookcatalogv2.dto.PublisherUpdateRequestDTO;
import com.itc.bookcatalogv2.dto.ResultPageResponseDTO;

public interface PublisherService {
    void createPublisher(PublisherCreateRequestDTO dto);

    void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);

    ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages,
                                                                      Integer limit,
                                                                      String sortBy,
                                                                      String direction,
                                                                      String publisherName);
}
