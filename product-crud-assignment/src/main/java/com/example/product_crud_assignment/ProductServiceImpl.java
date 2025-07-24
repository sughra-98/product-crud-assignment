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
    @Override
    public Product createProduct(Product product) {
        if (product == null) {
            return null; // Handle null product case
        }
        productRepository.save(product);
        return product; // Return the saved product
    }

    // TODO: Implement the method to return all products.
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products; // Return the list of products
    }

    // TODO: Implement the method to return a product by its ID.
    @Override
    public Product getProductById(Long id) {
        
        Product product = productRepository.findById(id).orElseThrow(
            () -> new ProductNotFoundException("Product with ID " + id + " not found")
        );
        return product; // Return the found product
    }

    // TODO: Implement the method to update a product by its ID.
    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        return productRepository.save(existingProduct); // Return the updated product
    }

    // TODO: Implement the method to delete a product by its ID.
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
        }


}
