package com.itc.bookcatalogv2.service.impl;

import com.itc.bookcatalogv2.domain.Publisher;
import com.itc.bookcatalogv2.dto.PublisherCreateRequestDTO;
import com.itc.bookcatalogv2.dto.PublisherListResponseDTO;
import com.itc.bookcatalogv2.dto.PublisherUpdateRequestDTO;
import com.itc.bookcatalogv2.dto.ResultPageResponseDTO;
import com.itc.bookcatalogv2.exceptions.BadRequestExceptions;
import com.itc.bookcatalogv2.repository.PublisherRepository;
import com.itc.bookcatalogv2.service.PublisherService;
import com.itc.bookcatalogv2.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public void createPublisher(PublisherCreateRequestDTO dto) {
        Publisher publisher = new Publisher();
        publisher.setName(dto.getPublisherName());
        publisher.setCompanyName(dto.getCompanyName());
        publisher.setAddress(dto.getAddress());

        publisherRepository.save(publisher);
    }

    @Override
    public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto) {
        Publisher publisher = publisherRepository.findBySecureId(publisherId)
                .orElseThrow(() -> new BadRequestExceptions("invalid.publisher_id"));

        publisher.setName(dto.getPublisherName() == null ||
                dto.getPublisherName().isBlank() ?
                publisher.getName() : dto.getPublisherName());

        publisher.setCompanyName(dto.getCompanyName() == null ||
                dto.getCompanyName().isBlank() ?
                publisher.getCompanyName() : dto.getCompanyName());

        publisher.setAddress(dto.getAddress() == null ||
                dto.getAddress().isBlank() ?
                publisher.getAddress() : dto.getAddress());

        publisherRepository.save(publisher);
    }

    @Override
    public ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages,
                                                                             Integer limit,
                                                                             String sortBy,
                                                                             String direction,
                                                                             String publisherName) {

        publisherName = StringUtils.isBlank(publisherName) ? "%" : publisherName + "%";

        Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction), sortBy));
        Pageable pageable = PageRequest.of(pages, limit, sort);

        Page<Publisher> pageResult = publisherRepository.findByNameLikeIgnoreCase(publisherName, pageable);
        List<PublisherListResponseDTO> dtos = pageResult.stream().map((p) -> {
            PublisherListResponseDTO dto = new PublisherListResponseDTO();
            dto.setPublisherId(p.getSecureId());
            dto.setPublisherName(p.getName());
            dto.setCompanyName(p.getCompanyName());

            return dto;
        }).collect(Collectors.toList());
        return PaginationUtil.createResultPageDTO(dtos, pageResult.getTotalElements(), pageResult.getTotalPages());
    }
}