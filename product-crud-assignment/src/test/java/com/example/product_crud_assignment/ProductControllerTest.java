package com.example.product_crud_assignment;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
@SpringBootTest
@AutoConfigureMockMvc

public class ProductControllerTest {

    // MockMvc will be used to perform HTTP requests in the tests
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("Get Products by ID")
    @Test 
    public void getProductByIdTest() throws Exception {
        // step 1: Build a GET request to the /products/{id} endpoint
        RequestBuilder request = MockMvcRequestBuilders.get("/products/1");
        // step 2 : Perform the request and expect a 200 OK status
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));


    }

    @Test 
    public void createProductTest() throws Exception {

        // step 1: Create a Product object to be sent in the request body
        Product newProduct = Product.builder()
                .name("New Product")
                .description("This is a new product")
                .price(50.0)
                .quantity(5)
                .build();
        // step 2: Convert the Product object to JSON using ObjectMapper
        String productJson = objectMapper.writeValueAsString(newProduct);
        // step 3: Build a POST request to the /products endpoint with the JSON body
        RequestBuilder request = MockMvcRequestBuilders.post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson);
        // step 4: Perform the request and expect a 201 Created status
        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("New Product"))
                .andExpect(jsonPath("$.description").value("This is a new product"))
                .andExpect(jsonPath("$.price").value(50.0))
                .andExpect(jsonPath("$.quantity").value(5));
    }





}