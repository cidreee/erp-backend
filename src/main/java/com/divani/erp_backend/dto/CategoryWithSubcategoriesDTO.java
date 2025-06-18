package com.divani.erp_backend.dto;

import java.util.List;

public class CategoryWithSubcategoriesDTO {
    public Integer categoryId;
    public String categoryName;
    public List<SubcategoryDTO> subcategories;

    public static class SubcategoryDTO {
        public Integer subcategoryId;
        public String subcategoryName;

        public SubcategoryDTO(Integer id, String name) {
            this.subcategoryId = id;
            this.subcategoryName = name;
        }
    }
    
}
    