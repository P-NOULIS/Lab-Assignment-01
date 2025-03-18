package com.example.LabAssignment01Noulis.services;
import com.example.LabAssignment01Noulis.models.Data;
import com.example.LabAssignment01Noulis.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {
    @Autowired
    private DataRepository repository;

    public List<Data> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Data> getProductById(Long id) {
        return repository.findById(id);
    }

    public Data createProduct(Data product) {
        return repository.save(product);
    }

    public Data updateProduct(Long id, Data updatedData) {
        return repository.findById(id).map(product -> {
            product.setProductName(updatedData.getProductName());
            product.setQt(updatedData.getQt());
            return repository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
