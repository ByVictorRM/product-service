package com.technica_studio.product_service.controller;

import com.technica_studio.product_service.model.Product;
import com.technica_studio.product_service.model.Summary;
import com.technica_studio.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/product")
    public ResponseEntity<Product> getSummary() {
        Product product = productService.getProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Product> insertSummary() {
        Product product = productService.insertProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(value = "/product")
    public ResponseEntity<Product> updateSummary() {
        Product product = productService.updateProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping(value = "/product")
    public ResponseEntity<Product> removeSummary() {
        Product product = productService.removeProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
