   package com.example.product_crud_assignment;

   import org.springframework.web.bind.annotation.*;

   import java.util.ArrayList;
   import java.util.List;

   @RestController
   @RequestMapping("/products")
   public class ProductController {

       private List<Product> products = new ArrayList<>();

       // Helper method to find the index of a product by ID
    private int getProductIndex(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return products.indexOf(product);
            }
        }
        // Not found
        return -1;
    }

       // TODO: Implement the method to add a new product
       @PostMapping 
       public Product createProduct(@RequestBody Product product) {
           // Add your code here to add the product to the list
           if (product.getId() == null || product.getId().isEmpty()) {
               throw new IllegalArgumentException("Product ID cannot be null or empty");
           }
            if (getProductIndex(product.getId()) != -1) {
                throw new IllegalArgumentException("Product with ID " + product.getId() + " already exists");
            }
            products.add(product);

           
            return product; // Modify this line to return the added product
       }

       // TODO: Implement the method to get all products
       @GetMapping
       
       public List<Product> getAllProducts() {
            
           // Add your code here to return the list of products

              if (products.isEmpty()) {
                throw new IllegalStateException("No products available");
              }
              
           return products; // Replace null with the actual list
       }

       // TODO: Implement the method to get a product by ID
       @GetMapping("/{id}")
       public Product getProductById(@PathVariable String id) {
           // Add your code here to find and return the product by ID
              int index = getProductIndex(id);
              if (index == -1) {
                throw new IllegalArgumentException("Product with ID " + id + " not found");
                }
            
            return products.get(index); // Replace null with the actual product
       }

       // TODO: Implement the method to update a product
       @PutMapping("/{id}")
       public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
           // Add your code here to update the product by ID
              int index = getProductIndex(id);
                if (index == -1) {
                    throw new IllegalArgumentException("Product with ID " + id + " not found");
                }
            if (updatedProduct.getId() == null || updatedProduct.getId().isEmpty()) {
                throw new IllegalArgumentException("Product ID cannot be null or empty");
            }
            if (!updatedProduct.getId().equals(id)) {
                throw new IllegalArgumentException("Product ID in the request body does not match the path variable");
            }
            products.set(index, updatedProduct);  

            updatedProduct.setId(id); // Ensure the ID remains the same
            // Return the updated product
            if (getProductIndex(updatedProduct.getId()) != index) {
                throw new IllegalArgumentException("Product with ID " + updatedProduct.getId() + " already exists");
            }
            updatedProduct.setId(id); // Ensure the ID remains the same
            products.set(index, updatedProduct); // Update the product in the list
            // Return the updated product
            return updatedProduct; // Replace null with the updated product
       }

       // TODO: Implement the method to delete a product
       @DeleteMapping("/{id}")
       public void deleteProduct(@PathVariable String id) {
           // Add your code here to remove the product by ID
              int index = getProductIndex(id);
                if (index == -1) {
                    throw new IllegalArgumentException("Product with ID " + id + " not found");
                }
            products.remove(index); // Remove the product from the list
       }
   }
