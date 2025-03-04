package com.technica_studio.product_service.service;

import com.technica_studio.product_service.model.Product;

public interface ProductService {
    Product getProduct();

    Product insertProduct();

    Product updateProduct();

    Product removeProduct();
}
