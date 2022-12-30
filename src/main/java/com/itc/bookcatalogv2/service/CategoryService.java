package com.itc.bookcatalogv2.service;

import com.itc.bookcatalogv2.dto.CategoryCreateUpdateRequestDTO;
import com.itc.bookcatalogv2.dto.CategoryListResponseDTO;
import com.itc.bookcatalogv2.dto.ResultPageResponseDTO;

public interface CategoryService {
    void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto);

    ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(
            Integer pages,
            Integer limit,
            String sortBy,
            String direction,
            String categoryName
    );


}
