package com.divani.erp_backend.repository;

import com.divani.erp_backend.model.InventoryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InventoryCategoryRepository extends JpaRepository<InventoryCategory, Integer> {
    Optional<InventoryCategory> findByNameIgnoreCase(String name);
}
