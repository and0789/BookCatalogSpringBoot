package com.itc.bookcatalogv2.service.impl;

import com.itc.bookcatalogv2.domain.Category;
import com.itc.bookcatalogv2.dto.CategoryCreateUpdateRequestDTO;
import com.itc.bookcatalogv2.dto.CategoryListResponseDTO;
import com.itc.bookcatalogv2.dto.ResultPageResponseDTO;
import com.itc.bookcatalogv2.exceptions.BadRequestExceptions;
import com.itc.bookcatalogv2.repository.CategoryRepository;
import com.itc.bookcatalogv2.service.CategoryService;
import com.itc.bookcatalogv2.util.PaginationUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto) {

        Category category = categoryRepository.findByCode(dto.getCode().toLowerCase()).orElse(new Category());
        if (category.getCode() == null) {
            category.setCode(dto.getCode().toLowerCase()); // create new data category
        }
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        categoryRepository.save(category);
    }

    @Override
    public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer limit, String sortBy, String direction, String categoryName) {
        categoryName = StringUtils.isEmpty(categoryName) ? "%" : categoryName + "%";
        Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction), sortBy));
        Pageable pageable = PageRequest.of(pages, limit, sort);
        Page<Category> pageResult = categoryRepository.findByNameLikeIgnoreCase(categoryName, pageable);
        List<CategoryListResponseDTO> dtos = pageResult.stream().map((c) -> {
            CategoryListResponseDTO dto = new CategoryListResponseDTO();
            dto.setCode(c.getCode());
            dto.setName(c.getName());
            dto.setDescription(c.getDescription());
            return dto;
        }).collect(Collectors.toList());
        return PaginationUtil.createResultPageDTO(dtos, pageResult.getTotalElements(), pageResult.getTotalPages());
    }

    @Override
    public List<Category> findCategories(List<String> categoryCodeList) {
        List<Category> categories = categoryRepository.findByCodeIn(categoryCodeList);
        if (categories.isEmpty()) throw new BadRequestExceptions("category cant empty");
        return categories;
    }

    @Override
    public List<CategoryListResponseDTO> constructDTO(List<Category> categories) {
        return categories.stream().map((c) -> {
            CategoryListResponseDTO dto = new CategoryListResponseDTO();
            dto.setCode(c.getCode());
            dto.setName(c.getName());
            dto.setDescription(c.getDescription());
            return dto;
        }).collect(Collectors.toList());
    }
}
