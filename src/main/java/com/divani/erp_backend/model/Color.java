package com.divani.erp_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer colorId;

    @Column(nullable = false, unique = true)
    private String name;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Color() {}
    public Color(String name) { this.name = name; }

    // Getters y setters...
    public Integer getColorId() {
    return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}