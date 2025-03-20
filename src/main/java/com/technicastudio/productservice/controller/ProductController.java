package com.technicastudio.productservice.controller;

import com.technicastudio.productservice.dto.ProductDTOList;
import com.technicastudio.productservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public ResponseEntity<ProductDTOList> getProducts(@RequestParam(name = "name", required = false) String name,
                                                     @RequestParam(name = "code", required = false) String code,
                                                     @RequestParam(name = "description", required = false) String description) {
        logger.info("GET product using name:{}, code:{}, description:{}", name, code, description);
        ProductDTOList productList = productService.getProduct(name, code, description);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping(value = "/products")
    public ResponseEntity<ProductDTOList> insertProducts(@RequestBody ProductDTOList requestBody) {
        logger.info("Creating products: {}", requestBody);
        ProductDTOList productList = productService.insertProduct(requestBody);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PutMapping(value = "/products")
    public ResponseEntity<ProductDTOList> updateProducts(@RequestBody ProductDTOList requestBody) {
        logger.info("Updating products: {}", requestBody);
        ProductDTOList productList = productService.updateProduct(requestBody);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/products")
    public ResponseEntity<ProductDTOList> removeProducts(@RequestBody ProductDTOList requestBody) {
        logger.info("Deleting products: {}", requestBody);
        ProductDTOList productList = productService.removeProduct(requestBody);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
