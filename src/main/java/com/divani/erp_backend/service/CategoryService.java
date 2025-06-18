package com.divani.erp_backend.service;

import org.springframework.stereotype.Service;
import com.divani.erp_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.divani.erp_backend.dto.CategoryWithSubcategoriesDTO;
import java.util.List;


@Service
public class CategoryService {
    @Autowired
    private InventoryCategoryRepository categoryRepo;

    @Autowired
    private InventorySubcategoryRepository subcategoryRepo;

    public List<CategoryWithSubcategoriesDTO> getAllWithSubcategories() {
        return categoryRepo.findAll().stream().map(category -> {
            CategoryWithSubcategoriesDTO dto = new CategoryWithSubcategoriesDTO();
            dto.categoryId = category.getCategoryId();
            dto.categoryName = category.getName();
            dto.subcategories = subcategoryRepo.findAll().stream()
                .filter(sc -> sc.getCategory().getCategoryId().equals(category.getCategoryId()))
                .map(sc -> new CategoryWithSubcategoriesDTO.SubcategoryDTO(
                        sc.getSubcategoryId(), sc.getName()))
                .toList();
            return dto;
        }).toList();
    }
}