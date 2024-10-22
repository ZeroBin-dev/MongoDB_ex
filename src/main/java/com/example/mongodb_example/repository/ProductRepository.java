package com.example.mongodb_example.repository;

import com.example.mongodb_example.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
