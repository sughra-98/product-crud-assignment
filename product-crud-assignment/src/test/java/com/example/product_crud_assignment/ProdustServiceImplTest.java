package com.example.product_crud_assignment;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.inject.Inject;

import org.mockito.InjectMocks;
import org.mockito.Mock;



@ExtendWith(MockitoExtension.class)
public class ProdustServiceImplTest {

    // Mock the ProductRepository
    // This allows us to simulate the behavior of the repository without needing a real database
    @Mock
    private ProductRepository productRepository;

    // inject the mock repository into the service
    @InjectMocks
    private ProductServiceImpl productService;

    // Test methods will go here
    @Test
    public void testCreateProduct() {
        // setup: Create a product instance to be saved
        Product product = Product.builder()
                .name("Test Product")
                .description("This is a test product")
                .price(100.0)
                .quantity(10)
                .build();
        
        when((productRepository.save(product))).thenReturn(product);

        // Execute: Call the createProduct method of the service
        Product createdProduct = productService.createProduct(product);
        // Assert: Verify that the product was created as expected
        assertEquals(product, createdProduct, "The created product should match the input product");

        // Verify that the repository's save method was called with the correct product
        verify(productRepository,times(1)).save(product);        
    }
}
