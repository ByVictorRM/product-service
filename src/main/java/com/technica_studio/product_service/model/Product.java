package com.technica_studio.product_service.model;

import java.math.BigInteger;

public class Product {
    private BigInteger id;
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
    private double rating;
    private boolean isAvailable;
    private BigInteger stockQuantity;

    public Product(BigInteger stockQuantity, boolean isAvailable, double rating, String modelNumber, String category, String material, String width, String height, String weight, String color, String brand, String code, String description, String name, BigInteger id) {
        this.stockQuantity = stockQuantity;
        this.isAvailable = isAvailable;
        this.rating = rating;
        this.modelNumber = modelNumber;
        this.category = category;
        this.material = material;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.color = color;
        this.brand = brand;
        this.code = code;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public BigInteger getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(BigInteger stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
