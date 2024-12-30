package com.rameshkittur.jpaTutorials.JPA.repositories;

import com.rameshkittur.jpaTutorials.JPA.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity>findByTitle(String title);

    Page<ProductEntity> findByTitle(String title, Pageable pageable);

    List<ProductEntity>findByCreatedAtAfter(LocalDateTime dateTime);

    List<ProductEntity>findByPriceGreaterThanOrQuantityLessThan(BigDecimal price,Integer quantity);

    List<ProductEntity>findByTitleContainingIgnoreCase(String title);

//    @Query("select e from ProductEntity e where title=?1 and price=?2")
@Query("select e from ProductEntity e where title=:title and price=:price")
    Optional<ProductEntity>findByTitlePrice(String title,BigDecimal price);

List<ProductEntity>findBy(Sort sortBy);
}
