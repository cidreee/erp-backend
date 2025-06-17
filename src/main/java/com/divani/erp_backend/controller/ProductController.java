package com.divani.erp_backend.controller;

import com.divani.erp_backend.dto.ProductRegistrationDTO;
import com.divani.erp_backend.model.Product;
import com.divani.erp_backend.repository.ProductRepository;
import com.divani.erp_backend.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    
    @Autowired
    private ProductService productService;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //GetProducts
    @GetMapping
    public List<Product> getALLProducts(){
        return productRepository.findAll();
    }

    //Save/POST products 
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PostMapping("/full-register")
    public ResponseEntity<String> registerFullProduct(@RequestBody ProductRegistrationDTO dto) {
        productService.registerFullProduct(dto);
        return ResponseEntity.ok("Producto registrado exitosamente.");
    }
}
