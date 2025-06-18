package com.divani.erp_backend.model;

import jakarta.persistence.*;;

@Entity
public class InventorySubcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subcategoryId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private InventoryCategory category;

    @Column(nullable = false)
    private String name;

    // Getters y Setters

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public InventoryCategory getCategory() {
        return category;
    }

    public void setCategory(InventoryCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
