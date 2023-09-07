package com.company.shoehub.service;

import com.company.shoehub.entity.Product;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
@EnableMongoRepositories
public interface ProductService {
    public List<Product> getAllProducts();
    public void addProduct(Product product);

    public Product updateProduct(Product product, String id);

    public void deleteProductById(String id);

}
