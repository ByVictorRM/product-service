package com.technicastudio.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Product")
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private String code;
    private String brand;
    private String color;
    private String weight;
    private String height;
    private String width;
    private String material;
    private String category;
    private String modelNumber;
    private BigDecimal rating;
    private boolean isAvailable;
    private BigInteger stockQuantity;
}
