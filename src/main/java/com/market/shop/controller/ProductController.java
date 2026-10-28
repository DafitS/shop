package com.market.shop.controller;


import com.market.shop.model.dao.Product;
import com.market.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")

public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id) {

        return productService.getProductById(id);
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProductById(@PathVariable UUID id) {

        return productService.deleteProductById(id);
    }

    @PutMapping()
    public Product updateProduct(@RequestBody Product product) {

        return productService.updateProduct(product);
    }
}
