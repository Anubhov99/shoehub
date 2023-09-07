package com.company.shoehub.service;

import com.company.shoehub.entity.Product;
import com.company.shoehub.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@EnableMongoRepositories
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public Product updateProduct(Product product, String id) {
        Product product1 = new Product();
        product1.setId(id);
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        productRepository.save(product1);
        return product1;

    }

    @Override
    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }
}
