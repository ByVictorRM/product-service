package com.technicastudio.productservice.service;

import com.technicastudio.productservice.dto.ProductDTOList;

public interface ProductService {
    ProductDTOList getProduct(String name, String code, String description);

    ProductDTOList insertProduct(ProductDTOList productEntityList);

    ProductDTOList updateProduct(ProductDTOList requestBody);

    ProductDTOList removeProduct(ProductDTOList requestBody);

}
