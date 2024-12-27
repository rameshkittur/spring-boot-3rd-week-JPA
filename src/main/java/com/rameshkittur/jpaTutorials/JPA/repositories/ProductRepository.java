package com.rameshkittur.jpaTutorials.JPA.repositories;

import com.rameshkittur.jpaTutorials.JPA.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity>findByTitle(String title);

    List<ProductEntity>findByCreatedAtAfter(LocalDateTime dateTime);

    List<ProductEntity>findByPriceGreaterThanOrQuantityLessThan(BigDecimal price,Integer quantity);

    List<ProductEntity>findByTitleContainingIgnoreCase(String title);




}
