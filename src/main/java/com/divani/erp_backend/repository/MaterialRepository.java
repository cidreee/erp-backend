package com.divani.erp_backend.repository;

import com.divani.erp_backend.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    Optional<Material> findByNameIgnoreCase(String name);
}