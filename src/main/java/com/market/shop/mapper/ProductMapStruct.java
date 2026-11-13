package com.market.shop.mapper;


import com.market.shop.model.dao.Product;
import com.market.shop.model.dto.product.ProductCreateDto;
import com.market.shop.model.dto.product.ProductResponseDto;
import com.market.shop.model.dto.product.ProductUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapStruct {

    ProductResponseDto mapProductToProductResponseDto(Product product);
    Product mapProductResponseDtoToProduct(ProductResponseDto productResponseDto);
    Product mapProductCreateDtoToProduct(ProductCreateDto productCreateDto);
    Product mapProductUpdateDtoToProduct(ProductUpdateDto productUpdateDto);
}
