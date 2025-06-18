package com.divani.erp_backend.repository;

import com.divani.erp_backend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface InventoryItemRepository extends JpaRepository<InventoryItem, Integer> {
    Optional<InventoryItem> findByCategoryAndSubcategoryAndBrandAndModelAndColorAndMaterial(
        InventoryCategory category,
        InventorySubcategory subcategory,
        Brand brand,
        Model model,
        Color color,
        Material material
    );
}