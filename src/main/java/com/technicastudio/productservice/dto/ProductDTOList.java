package com.technicastudio.productservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ProductDTOList extends AdditionalResponseInfo {
    public List<ProductDTO> productList;
}
