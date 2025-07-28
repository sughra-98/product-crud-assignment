   package com.example.product_crud_assignment;

   import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;


   
   @Entity
   @Builder
   @EqualsAndHashCode
   @Table(name = "Product")
   public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="name")
        private String name;
        @Column(name="description") 
        private String description;
        @Column(name="price")
        private double price;
        @Column(name="quantity")
        private int quantity;


         public Product() {
              // Default constructor for JPA
         }
         public Product(Long id, String name, String description, double price, int quantity) {
              this.id = id;
              this.name = name;
              this.description = description;
              this.price = price;
              this.quantity = quantity;
            }
 
       public Product( String name, String description, double price, int quantity) {
           this.name = name;
           this.description = description;
           this.price = price;
           this.quantity = quantity;
       }

       public Long getId() {
           return id;
       }

       public void setId(Long id) {
           this.id = id;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public String getDescription() {
           return description;
       }

       public void setDescription(String description) {
           this.description = description;
       }

       public double getPrice() {
           return price;
       }

       public void setPrice(double price) {
           this.price = price;
       }

       public int getQuantity() {
           return quantity;
       }

       public void setQuantity(int quantity) {
           this.quantity = quantity;
       }



       
   }
