package com.divani.erp_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materialId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    private Boolean isActive = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Material() {}
    public Material(String name) { this.name = name; }

    // Getters y setters...
    public Integer getMaterialId() {
    return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
}

}