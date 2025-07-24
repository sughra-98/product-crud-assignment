package com.example.product_crud_assignment;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(String id);

    Product updateProduct(String id, Product updatedProduct);

    void deleteProduct(String id);
}
