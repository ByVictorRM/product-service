package com.technica_studio.product_service.service;

import com.technica_studio.product_service.dto.ProductDTOList;
import com.technica_studio.product_service.entity.ProductEntityList;

public interface ProductService {
    ProductDTOList getProduct(String name, String code, String description);

    ProductDTOList insertProduct(ProductDTOList productEntityList);

    ProductDTOList updateProduct(ProductDTOList requestBody);

    ProductDTOList removeProduct(ProductDTOList requestBody);

}
