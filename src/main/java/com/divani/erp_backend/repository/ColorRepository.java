package com.divani.erp_backend.repository;

import com.divani.erp_backend.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Integer> {
    Optional<Color> findByNameIgnoreCase(String name);
}
