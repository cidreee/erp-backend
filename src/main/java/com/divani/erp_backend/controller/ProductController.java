package com.divani.erp_backend.controller;

import com.divani.erp_backend.model.Product;
import com.divani.erp_backend.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

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
}
