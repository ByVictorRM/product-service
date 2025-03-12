package com.technica_studio.product_service.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
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
