package com.itc.bookcatalogv2.service;

import com.itc.bookcatalogv2.domain.Publisher;
import com.itc.bookcatalogv2.dto.*;

public interface PublisherService {
    void createPublisher(PublisherCreateRequestDTO dto);

    void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);

    ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages,
                                                                      Integer limit,
                                                                      String sortBy,
                                                                      String direction,
                                                                      String publisherName);

    Publisher findPublisher(String publisherId);

    PublisherResponseDTO constructDTO(Publisher publisher);
}
