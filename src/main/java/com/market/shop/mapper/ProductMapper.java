package com.market.shop.mapper;

import com.market.shop.model.dao.Product;
import com.market.shop.model.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDto mapUserToProductResponse(Product product) {

        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .serialNumber(product.getSerialNumber())
                .active(product.getActive())
                .build();
    }
}
