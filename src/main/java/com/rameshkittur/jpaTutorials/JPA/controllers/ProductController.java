package com.rameshkittur.jpaTutorials.JPA.controllers;

import com.rameshkittur.jpaTutorials.JPA.entities.ProductEntity;
import com.rameshkittur.jpaTutorials.JPA.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
   private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Page<ProductEntity> getProducts(
            @RequestParam(defaultValue = "price") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "5") Integer pageSize
    ){
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
//        System.out.println(productRepository.findAll(pageable));
//        return productRepository.findBy(Sort.by(Sort.Direction.ASC,sortBy,"price"));
        return productRepository.findAll(pageable);


//        String exTitle = "Coke";
//        return productRepository.findByTitle(exTitle,pageable);

    }
}
