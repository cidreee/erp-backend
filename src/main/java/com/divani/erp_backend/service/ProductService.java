package com.divani.erp_backend.service;

import com.divani.erp_backend.dto.ProductRegistrationDTO;
import com.divani.erp_backend.model.*;
import com.divani.erp_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void registerFullProduct(ProductRegistrationDTO dto) {
        // 1. Crear o reutilizar marca
        Brand brand = brandRepo.findByName(dto.brandName)
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
        Material material = materialRepo.findByName(dto.materialName)
                .orElseGet(() -> materialRepo.save(new Material(dto.materialName)));

        // 4. Crear o reutilizar color
        Color color = colorRepo.findByName(dto.colorName)
                .orElseGet(() -> colorRepo.save(new Color(dto.colorName)));

        // 5. Crear InventoryItem
        InventoryItem item = new InventoryItem();
        item.setName(dto.itemName);
        item.setCategoryId(dto.categoryId);
        item.setSubcategoryId(dto.subcategoryId);
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

        // 6. Crear Product
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