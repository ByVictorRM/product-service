package com.technicastudio.productservice.repository;

import com.technicastudio.productservice.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductListRepository extends MongoRepository<ProductEntity, String>{

    List<ProductEntity> findAllByName(String name);

    List<ProductEntity> findAllByCode(String code);

    List<ProductEntity> findByCodeIn(List<String> code);

    List<ProductEntity> findAllByDescription(@Param("description") String description);

    List<ProductEntity> findAllByNameAndCodeAndDescription(@Param("name") String name,
                                                        @Param("code") String code,
                                                        @Param("description") String description);
}
