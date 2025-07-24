package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    private ProductRepository productRepository;

    @Autowired
    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @PostConstruct
    public void loadData() {
        productRepository.deleteAll();
        productRepository.save(new Product("Laptop", "High performance laptop", 1200.00,10));
        productRepository.save(new Product("Smartphone", "Latest model smartphone", 800.00,20));
        productRepository.save(new Product("Tablet", "Portable tablet with stylus", 600.00,25));
        productRepository.save(new Product("Smartwatch", "Feature-rich smartwatch", 250.00,12));   
        productRepository.save(new Product("Headphones", "Noise-cancelling headphones", 150.00,13));
        productRepository.save(new Product("Bluetooth Speaker", "Portable Bluetooth speaker", 100.00,13));
        productRepository.save(new Product("Camera", "High-resolution digital camera", 900.00,30));
    }
}
