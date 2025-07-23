package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // TODO: Use @Autowired to inject the ProductRepository via constructor
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // TODO: Implement the method to create a product.
    public Product createProduct(Product product) {
        if (product == null) {
            return null; // Handle null product case
        }
        productRepository.save(product);
        return product; // Return the saved product
    }

    // TODO: Implement the method to return all products.
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            return List.of(); // Return an empty list if no products exist
        }
        return products; // Return the list of products
    }

    // TODO: Implement the method to return a product by its ID.
    public Product getProductById(String id) {
        
        Product product = productRepository.findById(id);
        if (product == null) {
            return null; // Return null if no product is found with the given ID
        }
        return product; // Return the found product
    }

    // TODO: Implement the method to update a product by its ID.
    public Product updateProduct(String id, Product updatedProduct) {
        if (id == null || id.isEmpty() || updatedProduct == null) {
            return null; // Handle null or empty ID and product case
        }
        Product existingProduct = productRepository.findById(id);
        if (existingProduct == null) {
            return null; // Return null if no product is found with the given ID
        }
        updatedProduct.setId(id); // Ensure the ID of the updated product matches the existing one
        productRepository.save(updatedProduct); // Save the updated product
        return updatedProduct; // Return the updated product
        }

    // TODO: Implement the method to delete a product by its ID.
    public void deleteProduct(String id) {
        if (id == null || id.isEmpty()) {
            return; // Handle null or empty ID case
        }
        Product existingProduct = productRepository.findById(id);
        if (existingProduct != null) {
            productRepository.delete(id); // Delete the product if it exists
        }
    }
}
