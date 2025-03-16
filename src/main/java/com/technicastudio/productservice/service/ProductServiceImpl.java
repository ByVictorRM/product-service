package com.technicastudio.productservice.service;

import com.technicastudio.productservice.dto.BooleanStr;
import com.technicastudio.productservice.dto.ProductDTO;
import com.technicastudio.productservice.dto.ProductDTOList;
import com.technicastudio.productservice.entity.ProductEntity;
import com.technicastudio.productservice.repository.ProductListRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductListRepository productListRepository;

    @Override
    public ProductDTOList getProduct(String name, String code, String description) {
        ProductDTOList responseBody = new ProductDTOList();
        if (!StringUtils.isBlank(name) && StringUtils.isBlank(code) && StringUtils.isBlank(description)) {
            List<ProductEntity> productEntityList = productListRepository.findByName(name);
            responseBody.setProductList(createProductDTOList(productEntityList));
        } else if (StringUtils.isBlank(name) && !StringUtils.isBlank(code) && StringUtils.isBlank(description)) {
            List<ProductEntity> productEntityList = productListRepository.findByCode(code);
            responseBody.setProductList(createProductDTOList(productEntityList));
        } else if (StringUtils.isBlank(name) && StringUtils.isBlank(code) && !StringUtils.isBlank(description)) {
            List<ProductEntity> productEntityList = productListRepository.findByDescription(description);
            responseBody.setProductList(createProductDTOList(productEntityList));
        } else if (!StringUtils.isBlank(name) && !StringUtils.isBlank(code) && !StringUtils.isBlank(description)) {
            List<ProductEntity> productEntityList = productListRepository.findByNameAndCodeAndDescription(name, code, description);
            responseBody.setProductList(createProductDTOList(productEntityList));
        } else {
            List<ProductEntity> productEntityList = productListRepository.findAll();
            responseBody.setProductList(createProductDTOList(productEntityList));
        }
        return responseBody;
    }

    @Override
    public ProductDTOList insertProduct(ProductDTOList requestBody) {
        validateRequestBody(requestBody);
        ProductDTOList responseBody = new ProductDTOList();
        List<ProductEntity> productEntityList = new ArrayList<>();
        try {
            productEntityList = productListRepository.insert(createProductEntityList(requestBody.getProductList()));
        } catch (DuplicateKeyException e) {
            responseBody.setErrorMessage("An error occurred while inserting the product.");
        }
        responseBody.setProductList(createProductDTOList(productEntityList));
        return responseBody;
    }

    @Override
    public ProductDTOList updateProduct(ProductDTOList requestBody) {
        validateRequestBody(requestBody);
        ProductDTOList responseBody = new ProductDTOList();
        List<ProductEntity> productEntityList = new ArrayList<>();

        try {
            List<String> codeList = requestBody.getProductList().stream().filter(Objects::nonNull)
                    .map(ProductDTO::getCode).collect(Collectors.toList());
            productEntityList = productListRepository.findByCodeIn(codeList);
            setNewValues(productEntityList, requestBody);
            productEntityList = productListRepository.saveAll(productEntityList);

            if (codeList.size() != productEntityList.size()) {
                logger.warn("The update process was partially successful. Some objects were not updated.");
            }
        } catch (DuplicateKeyException e) {
            logger.error("DuplicateKeyException", e);
            responseBody.setErrorMessage("An error occurred while updating the product.");
        }

        responseBody.setProductList(createProductDTOList(productEntityList));
        return responseBody;
    }

    private List<ProductDTO> createProductDTOList(List<ProductEntity> productEntityList) {
        return productEntityList.stream()
                .map(productEntity -> ProductDTO.builder()
                        .name(productEntity.getName())
                        .description(productEntity.getDescription())
                        .code(productEntity.getCode())
                        .brand(productEntity.getBrand())
                        .color(productEntity.getColor())
                        .weight(productEntity.getWeight())
                        .height(productEntity.getHeight())
                        .width(productEntity.getWidth())
                        .material(productEntity.getMaterial())
                        .category(productEntity.getCategory())
                        .modelNumber(productEntity.getModelNumber())
                        .rating(productEntity.getRating())
                        .isAvailable(productEntity.isAvailable())
                        .stockQuantity(productEntity.getStockQuantity())
                        .build())
                .collect(Collectors.toList());
    }

    private List<ProductEntity> createProductEntityList(List<ProductDTO> productDTOList) {
        return productDTOList.stream()
                .map(productDTO -> ProductEntity.builder()
                        .name(productDTO.getName())
                        .description(productDTO.getDescription())
                        .code(productDTO.getCode())
                        .brand(productDTO.getBrand())
                        .color(productDTO.getColor())
                        .weight(productDTO.getWeight())
                        .height(productDTO.getHeight())
                        .width(productDTO.getWidth())
                        .material(productDTO.getMaterial())
                        .category(productDTO.getCategory())
                        .modelNumber(productDTO.getModelNumber())
                        .rating(productDTO.getRating())
                        .isAvailable(productDTO.isAvailable())
                        .stockQuantity(productDTO.getStockQuantity())
                        .build())
                .collect(Collectors.toList());
    }

    private void setNewValues(List<ProductEntity> productsToSave, ProductDTOList requestBody) {
        productsToSave.forEach(productToSave -> {
            requestBody.getProductList().stream()
                    .filter(product -> product.getCode().equals(productToSave.getCode()))
                    .findFirst()
                    .ifPresent(productDTO -> {
                        Optional.ofNullable(productDTO.getName()).ifPresent(productToSave::setName);
                        Optional.ofNullable(productDTO.getDescription()).ifPresent(productToSave::setDescription);
                        Optional.ofNullable(productDTO.getCode()).ifPresent(productToSave::setCode);
                        Optional.ofNullable(productDTO.getBrand()).ifPresent(productToSave::setBrand);
                        Optional.ofNullable(productDTO.getColor()).ifPresent(productToSave::setColor);
                        Optional.ofNullable(productDTO.getWeight()).ifPresent(productToSave::setWeight);
                        Optional.ofNullable(productDTO.getHeight()).ifPresent(productToSave::setHeight);
                        Optional.ofNullable(productDTO.getWidth()).ifPresent(productToSave::setWidth);
                        Optional.ofNullable(productDTO.getMaterial()).ifPresent(productToSave::setMaterial);
                        Optional.ofNullable(productDTO.getCategory()).ifPresent(productToSave::setCategory);
                        Optional.ofNullable(productDTO.getModelNumber()).ifPresent(productToSave::setModelNumber);
                        Optional.ofNullable(productDTO.getRating()).ifPresent(productToSave::setRating);
                        Optional.ofNullable(productDTO.getAvailability())
                                .map(BooleanStr::getValue)
                                .ifPresent(productToSave::setAvailable);
                        Optional.ofNullable(productDTO.getStockQuantity()).ifPresent(productToSave::setStockQuantity);
                    });
        });
    }

    @Override
    public ProductDTOList removeProduct(ProductDTOList requestBody) {
        validateRequestBody(requestBody);
        ProductDTOList responseBody = new ProductDTOList();
        List<ProductEntity> productEntityList = new ArrayList<>();
        try {
            List<String> codeList = requestBody.getProductList().stream().filter(Objects::nonNull)
                    .map(ProductDTO::getCode).collect(Collectors.toList());

            productEntityList = productListRepository.findByCodeIn(codeList);

            productListRepository.deleteAll(productEntityList);

        } catch (Exception e) {
            String msg = "An error occurred while deleting the product";
            logger.error(msg);
        }
        responseBody.setProductList(createProductDTOList(productEntityList));
        return responseBody;
    }

    private void validateRequestBody(ProductDTOList requestBody) {
        if (requestBody == null || requestBody.getProductList() == null || requestBody.getProductList().isEmpty()) {
            String msg = "Product list cannot be null or empty";
            logger.error(msg);
            throw new IllegalArgumentException(msg);
        }
    }

}
