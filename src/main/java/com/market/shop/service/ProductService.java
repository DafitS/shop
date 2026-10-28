package com.market.shop.service;

import com.market.shop.model.dao.Product;
import com.market.shop.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;

    public Product getProductById(UUID id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    @Transactional
    public void deleteProductById(UUID id) {

        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product) {

        return productRepository.save(product);
    }
}
