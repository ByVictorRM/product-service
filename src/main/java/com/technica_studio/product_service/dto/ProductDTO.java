package com.technica_studio.product_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
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
    private BooleanStr availability;
    private boolean isAvailable;
    private BigInteger stockQuantity;

}
