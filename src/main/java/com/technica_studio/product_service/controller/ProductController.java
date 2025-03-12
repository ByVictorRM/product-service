package com.technica_studio.product_service.controller;

import com.technica_studio.product_service.dto.ProductDTOList;
import com.technica_studio.product_service.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping(value = "/product")
    public ResponseEntity<ProductDTOList> getSummary(@RequestParam(name = "name", required = false) String name,
                                                     @RequestParam(name = "code", required = false) String code,
                                                     @RequestParam(name = "description", required = false) String description) {
        logger.info("GET product using id:{}, code:{}, description:{}", name, code, description);
        ProductDTOList productList = productService.getProduct(name, code, description);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping(value = "/product")
    public ResponseEntity<ProductDTOList> insertSummary(@RequestBody ProductDTOList requestBody) {
        ProductDTOList productList = productService.insertProduct(requestBody);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PutMapping(value = "/product")
    public ResponseEntity<ProductDTOList> updateSummary(@RequestBody ProductDTOList requestBody) {
        ProductDTOList productList = productService.updateProduct(requestBody);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/product")
    public ResponseEntity<ProductDTOList> removeSummary(@RequestBody ProductDTOList requestBody) {
        ProductDTOList productList = productService.removeProduct(requestBody);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
