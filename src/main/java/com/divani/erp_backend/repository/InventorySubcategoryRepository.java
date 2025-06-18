package com.divani.erp_backend.repository;

import com.divani.erp_backend.model.InventoryCategory;
import com.divani.erp_backend.model.InventorySubcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InventorySubcategoryRepository extends JpaRepository<InventorySubcategory, Integer> {
    Optional<InventorySubcategory> findByNameIgnoreCaseAndCategory(String name, InventoryCategory category);
}
