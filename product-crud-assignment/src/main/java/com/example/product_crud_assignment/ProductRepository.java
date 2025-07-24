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
          
        products.add(product);
    
        return product;
    }

    public List<Product> findAll() {

        
        return products; 
    }
    

    public Product findById(int index) {
            // TODO: Implement the method to find a product by its ID.
        return products.get(index); // Return null if not found
    }

   
    public Product update(int index, Product updatedProduct) {
         // TODO: Implement the method to update a product by its ID.
        Product productToupdate = products.get(index);
        productToupdate.setName(updatedProduct.getName());
        productToupdate.setDescription(updatedProduct.getDescription());
        productToupdate.setPrice(updatedProduct.getPrice());
        productToupdate.setQuantity(updatedProduct.getQuantity());
        productToupdate.setId(updatedProduct.getId()); // Ensure the ID is updated if necessary

        return productToupdate; // Return the updated product
        
    }

    public void delete(int index) {
        
        products.remove(index); 
        
    }

    
}
