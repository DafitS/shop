package com.market.shop.controller;


import com.market.shop.mapper.ProductMapper;
import com.market.shop.model.dao.Product;
import com.market.shop.model.dto.ProductResponseDto;
import com.market.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")

public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable UUID id) {

        return productMapper.mapUserToProductResponse(productService.getProductById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createProduct(@RequestBody Product product) {

        return productMapper.mapUserToProductResponse(productService.createProduct(product));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable UUID id) {

         productService.deleteProductById(id);
    }

    @PutMapping
    public ProductResponseDto updateProduct(@RequestBody Product product) {

        return productMapper.mapUserToProductResponse(productService.updateProduct(product));
    }

    @GetMapping
    public Page<ProductResponseDto> getPageProducts(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.getPageProducts(pageable)
                .map(productMapper::mapUserToProductResponse);
    }

}
