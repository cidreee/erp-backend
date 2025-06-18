package com.divani.erp_backend.service;

import com.divani.erp_backend.dto.ProductRegistrationDTO;
import com.divani.erp_backend.model.*;
import com.divani.erp_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private BrandRepository brandRepo;

    @Autowired
    private ModelRepository modelRepo;

    @Autowired
    private MaterialRepository materialRepo;

    @Autowired
    private ColorRepository colorRepo;

    @Autowired
    private InventoryItemRepository itemRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private InventoryCategoryRepository categoryRepo;

    @Autowired
    private InventorySubcategoryRepository subcategoryRepo;



    public void registerFullProduct(ProductRegistrationDTO dto) {
        InventoryCategory category = categoryRepo.findByNameIgnoreCase(dto.categoryName)
        .orElseGet(() -> {
                InventoryCategory newCategory = new InventoryCategory();
                newCategory.setName(dto.categoryName);
                return categoryRepo.save(newCategory);
        });

        InventorySubcategory subcategory = subcategoryRepo
        .findByNameIgnoreCaseAndCategory(dto.subcategoryName, category)
        .orElseGet(() -> {
            InventorySubcategory sc = new InventorySubcategory();
            sc.setName(dto.subcategoryName);
            sc.setCategory(category);
            return subcategoryRepo.save(sc);
        });

        // 1. Crear o reutilizar marca
        Brand brand = brandRepo.findByNameIgnoreCase(dto.brandName)
                .orElseGet(() -> brandRepo.save(new Brand(dto.brandName)));

        // 2. Crear o reutilizar modelo
        Model model = modelRepo.findByNameAndBrand(dto.modelName, brand)
                .orElseGet(() -> {
                    Model m = new Model();
                    m.setName(dto.modelName);
                    m.setDescription(dto.modelDescription);
                    m.setBrand(brand);
                    return modelRepo.save(m);
                });

        // 3. Crear o reutilizar material
        Material material = materialRepo.findByNameIgnoreCase(dto.materialName)
                .orElseGet(() -> materialRepo.save(new Material(dto.materialName)));

        // 4. Crear o reutilizar color
        Color color = colorRepo.findByNameIgnoreCase(dto.colorName)
                .orElseGet(() -> colorRepo.save(new Color(dto.colorName)));

        // 5. Validar si ya existe un InventoryItem con la misma combinación
        Optional<InventoryItem> existingItem = itemRepo
        .findByCategoryAndSubcategoryAndBrandAndModelAndColorAndMaterial(
                category,
                subcategory,
                brand,
                model,
                color,
                material
        );

        if (existingItem.isPresent()) {
                throw new IllegalArgumentException("Este producto ya existe en el inventario.");
        }

        // 6. Crear InventoryItem
        InventoryItem item = new InventoryItem();
        item.setName(dto.itemName);
        item.setCategory(category);
        item.setSubcategory(subcategory);
        item.setSupplierId(dto.supplierId);
        item.setUnitId(dto.unitId);
        item.setBrand(brand);
        item.setModel(model);
        item.setMaterial(material);
        item.setColor(color);
        item.setStock(dto.stock);
        item.setMinimumInStock(dto.minimumInStock);
        item.setUnitCost(dto.unitCost);
        item = itemRepo.save(item);

        // 7. Crear Product
        Product product = new Product();
        product.setInventoryItem(item);
        product.setName(dto.productName);
        product.setDescription(dto.productDescription);
        product.setPrice(dto.price);
        product.setDiscount(dto.discount);
        product.setIva(dto.iva);
        productRepo.save(product);
    }

}