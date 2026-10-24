package com.market.shop.service;

import com.market.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;
}
