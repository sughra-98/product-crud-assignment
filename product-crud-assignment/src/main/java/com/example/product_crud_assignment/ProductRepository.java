package com.example.product_crud_assignment;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        // TODO: Preload some products into the list.
        products.add(new Product("1", "Laptop", "High performance laptop", 1200.00, 10));
        products.add(new Product("2", "Smartphone", "Latest model smartphone", 800.00, 20));
        products.add(new Product("3", "Tablet", "Portable tablet device", 300.00, 15)); 
    }

    public Product save(Product product) {
            // TODO: Implement the method to save a product to the list.
        if (product == null) {
            return null; // Handle null product case
        }
        // Check if the product already exists by ID
        int index = getProductIndex(product.getId());
        if (index != -1) {
            // Update existing product
            products.set(index, product);
        } else {
            // Add new product
            products.add(product);
        }
        return product; // Return the saved product
    }

    public List<Product> findAll() {

        // TODO: Implement the method to return all products.
        if (products.isEmpty()) {
            return new ArrayList<>(); // Return an empty list if no products exist
        }
        return new ArrayList<>(products); // Return a copy of the product list
    }
    

    public Product findById(String id) {
            // TODO: Implement the method to find a product by its ID.
        if (id == null || id.isEmpty()) {
            return null; // Handle null or empty ID case    
        }
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product; // Return the product if found
            }
        }   
        // If no product is found with the given ID, return null   
        return null;
    }

   
    public Product update(String id, Product updatedProduct) {
         // TODO: Implement the method to update a product by its ID.
         if (id == null || id.isEmpty()) {
            return null; // Handle null or empty ID case    
        }
        if (updatedProduct == null) {
            return null; // Handle null product case
        }
        int index = getProductIndex(id);
        if (index != -1) {
            products.set(index, updatedProduct); // Update the product at the found index
            return updatedProduct; // Return the updated product
        }       
        return null; // Replace with your code
    }

    // TODO: Implement the method to delete a product by its ID.
    public void delete(String id) {
            // TODO: Implement the method to delete a product by its ID.
        if (id == null || id.isEmpty()) {
            return ; // Handle null or empty ID case
        }
        int index = getProductIndex(id);
        if (index != -1) {
            products.remove(index); // Remove the product at the found index
        }
    }

    // Helper method to find the index of a product by ID
    private int getProductIndex(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
