package com.example.mongodb_example.controller;

import com.example.mongodb_example.model.Product;
import com.example.mongodb_example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

  private final ProductRepository productRepository;

  /**
   * 생성
   */
  @PostMapping
  public Product createProduct(@RequestBody Product product){
    return productRepository.save(product);
  }

  /**
   * 전체조회
   */
  @GetMapping
  public List<Product> getAllProducts(){
    return productRepository.findAll();
  }

  /**
   * 상세조회
   */
  @GetMapping("/{id}")
  


  /**
   * 수정
   */
  @PutMapping("/{id}")

  /**
   * 삭제
   */
  @DeleteMapping("/{id}")

}
