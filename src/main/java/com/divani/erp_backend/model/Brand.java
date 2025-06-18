package com.divani.erp_backend.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandId;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    private Boolean isActive = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters y setters
    public Integer getBrandId() { return brandId; }
    public void setBrandId(Integer brandId) { this.brandId = brandId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Brand() {}
    public Brand(String name) { this.name = name; }
}