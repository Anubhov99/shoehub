package com.company.shoehub.controller;

import com.company.shoehub.entity.Product;
import com.company.shoehub.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@EnableMongoRepositories
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @ApiIgnore
    @GetMapping("/")
    public void redirectToSwagger(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping("/getAllProducts")
    public HashMap<String,List<Product>> getAllProducts() {
        HashMap<String,List<Product>> hashMap = new HashMap<>();
        hashMap.put("Products",productService.getAllProducts());
        return hashMap;
    }

    @PostMapping("/addProducts")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
       productService.addProduct(product);
       return new ResponseEntity<>("Item added", HttpStatus.OK);

    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Long id){
        productService.updateProduct(product,id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>("Item deleted" , HttpStatus.OK);
    }

}