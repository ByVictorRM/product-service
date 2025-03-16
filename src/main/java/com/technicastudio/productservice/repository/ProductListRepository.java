package com.technicastudio.productservice.repository;

import com.technicastudio.productservice.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProductListRepository extends MongoRepository<ProductEntity, String>{

    List<ProductEntity> findByName(String name);

    List<ProductEntity> findByCode(String code);

    List<ProductEntity> findByCodeIn(List<String> codes);

    List<ProductEntity> findByDescription(String description);

    List<ProductEntity> findByNameAndCodeAndDescription(String name,
                                                        String code,
                                                        String description);
}
