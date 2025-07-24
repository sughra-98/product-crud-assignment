package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // TODO: Use @Autowired to inject the ProductRepository via constructor
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
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
        return products; // Return the list of products
    }

    // TODO: Implement the method to return a product by its ID.
    public Product getProductById(String id) {
        
        Product product = productRepository.findById(getProductIndex(id));
        return product; // Return the found product
    }

    // TODO: Implement the method to update a product by its ID.
    public Product updateProduct(String id, Product updatedProduct) {
        productRepository.update(getProductIndex(id), updatedProduct);
        return updatedProduct; // Return the updated product

    }

    // TODO: Implement the method to delete a product by its ID.
    public void deleteProduct(String id) {
        productRepository.delete(getProductIndex(id));
        }

    private int getProductIndex(String id) {
        for (Product product : productRepository.findAll()) {
            if (product.getId().equals(id)) {
                return productRepository.findAll().indexOf(product);
            }
        }
        throw new ProductNotFoundException("Product with ID " + id + " not found");

    }

}
