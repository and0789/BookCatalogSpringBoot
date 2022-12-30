package com.itc.bookcatalogv2.util;

import com.itc.bookcatalogv2.dto.ResultPageResponseDTO;
import org.springframework.data.domain.Sort;

import java.util.List;

public class PaginationUtil {

    public static <T> ResultPageResponseDTO<T> createResultPageDTO(List<T> dtos, Long totalElement, Integer pages) {
        ResultPageResponseDTO<T> result = new ResultPageResponseDTO<T>();
        result.setPages(pages);
        result.setElements(totalElement);
        result.setResult(dtos);
        return result;
    }

    public static Sort.Direction getSortBy(String sortBy) {
        if (sortBy.equalsIgnoreCase("acs")) {
            return Sort.Direction.ASC;
        } else {
            return Sort.Direction.DESC;
        }
    }
}
