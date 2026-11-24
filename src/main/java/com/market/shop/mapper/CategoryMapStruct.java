package com.market.shop.mapper;


import com.market.shop.model.dao.Category;
import com.market.shop.model.dto.category.CategoryCreateDto;
import com.market.shop.model.dto.category.CategoryResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapStruct {

    CategoryResponseDto mapCategoryToCategoryResponseDto(Category category);
    Category mapCategoryCreateDtoToCategory(CategoryCreateDto categoryCreateDto);
}
