package com.itc.bookcatalogv2.service;

import com.itc.bookcatalogv2.domain.Category;
import com.itc.bookcatalogv2.dto.CategoryCreateUpdateRequestDTO;
import com.itc.bookcatalogv2.dto.CategoryListResponseDTO;
import com.itc.bookcatalogv2.dto.ResultPageResponseDTO;

import java.util.List;


public interface CategoryService {
    void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto);

    ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(
            Integer pages,
            Integer limit,
            String sortBy,
            String direction,
            String categoryName
    );

    List<Category> findCategories(List<String> categoryCodeList);


    List<CategoryListResponseDTO> constructDTO(List<Category> categories);


}
