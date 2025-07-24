package com.example.product_crud_assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository provides methods like save, findAll, findById, deleteById

}
