package com.technica_studio.product_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ProductDTOList extends AdditionalResponseInfo {
    public List<ProductDTO> productList;
}
