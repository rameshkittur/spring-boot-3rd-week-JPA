package com.rameshkittur.jpaTutorials.JPA;

import com.rameshkittur.jpaTutorials.JPA.entities.ProductEntity;
import com.rameshkittur.jpaTutorials.JPA.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JpaApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@Test
	void saveProduct(){
		ProductEntity newProduct = new ProductEntity();
		newProduct.setSku("Dairy1233");
		newProduct.setTitle("Dairy");
		newProduct.setPrice(BigDecimal.valueOf(123.2));
		newProduct.setQuantity(43);

		ProductEntity secondProduct = ProductEntity.builder()
				.sku("Coke145")
				.title("Coke")
				.price(BigDecimal.valueOf(12.4))
				.quantity(21)
				.build();

		ProductEntity saved = productRepository.save(newProduct);
		System.out.println(saved);

		ProductEntity savedSecondProduct = productRepository.save(secondProduct);
		System.out.println(savedSecondProduct);
	}

	@Test
	void getAllProducts(){
		List<ProductEntity> productEntities = productRepository.findAll();
		System.out.println(productEntities);
	}

	@Test
	void getProductCreatedAfterGivenTime(){
		List<ProductEntity>productEntities = productRepository.findByCreatedAtAfter(LocalDateTime.of(2024,1,1,0,0));
		System.out.println(productEntities);
	}

	@Test
	void getByFullTitleOrPartialTitle(){
		List<ProductEntity>productWithTitle = productRepository.findByTitle("Coke");
		List<ProductEntity>productWithPartialTitle = productRepository.findByTitleContainingIgnoreCase("Coke");

		System.out.println("With the Full title " + productWithTitle);
		System.out.println("With the Partial title " + productWithPartialTitle);

	}

	@Test
	void getProductWithGivenPriceAndQuantity(){
		List<ProductEntity>productEntities = productRepository.findByPriceGreaterThanOrQuantityLessThan(BigDecimal.valueOf(13.5),100);
		System.out.println(productEntities);
	}

}
