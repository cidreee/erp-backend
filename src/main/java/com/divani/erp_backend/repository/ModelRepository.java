package com.divani.erp_backend.repository;
import com.divani.erp_backend.model.Model;

import com.divani.erp_backend.model.Brand;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    Optional<Model> findByNameAndBrand(String name, Brand brand);
}