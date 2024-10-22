package com.example.mongodb_example.controller;

import com.example.mongodb_example.model.Product;
import com.example.mongodb_example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

  private final ProductRepository productRepository;

  /**
   * 생성
   */
  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }

  /**
   * 전체조회
   */
  @GetMapping
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  /**
   * 상세조회
   */
  @GetMapping("/{id}")
  public Optional<Product> getProductById(@PathVariable String id) {
    return productRepository.findById(id);
  }

  /**
   * 수정
   */
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable String id, @RequestBody Product productDetail) {
    Optional<Product> optionalProduct = productRepository.findById(id);
    if (optionalProduct.isPresent()) {
      Product product = optionalProduct.get();
      product.setName(productDetail.getName());
      product.setPrice(productDetail.getPrice());
      return productRepository.save(product);
    } else {
      return null;
    }
  }

  /**
   * 삭제
   */
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable String id) {
    productRepository.deleteById(id);
  }

}
