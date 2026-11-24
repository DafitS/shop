package com.market.shop.controller;


import com.market.shop.mapper.ProductMapStruct;
import com.market.shop.model.dao.Product;
import com.market.shop.model.dto.product.ProductCreateDto;
import com.market.shop.model.dto.product.ProductResponseDto;
import com.market.shop.model.dto.product.ProductUpdateDto;
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
    private final ProductMapStruct productMapper;

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable UUID id) {
        return productMapper.mapProductToProductResponseDto(productService.getProductById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createProduct(@RequestBody ProductCreateDto product) {
        Product newProduct = productMapper.mapProductCreateDtoToProduct(product);
        return productMapper.mapProductToProductResponseDto(productService.createProduct(newProduct, product.categoryId()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable UUID id) {
        productService.deleteProductById(id);
    }

    @PutMapping
    public ProductResponseDto updateProduct(@RequestBody ProductUpdateDto product) {
        Product updateProduct = productMapper.mapProductUpdateDtoToProduct(product);
        return productMapper.mapProductToProductResponseDto(productService.updateProduct(updateProduct));
    }

    @GetMapping
    public Page<ProductResponseDto> getPageProducts(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.getPageProducts(pageable)
                .map(productMapper::mapProductToProductResponseDto);
    }

}
