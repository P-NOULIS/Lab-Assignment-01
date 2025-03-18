package com.example.LabAssignment01Noulis.controllers;

import com.example.LabAssignment01Noulis.models.Data;
import com.example.LabAssignment01Noulis.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class DataController {

    @Autowired
    private DataService service;

    // Get all products
    @GetMapping
    public List<Data> getAllProducts() {
        return service.getAllProducts();
    }

    // Get a single product by ID
    @GetMapping("/{id}")
    public Data getProductById(@PathVariable Long id) {
        return service.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Add a new product
    @PostMapping
    public Data createProduct(@RequestBody Data product) {
        return service.createProduct(product);
    }

    // Update existing product
    @PutMapping("/{id}")
    public Data updateProduct(@PathVariable Long id, @RequestBody Data product) {
        return service.updateProduct(id, product);
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }
}
