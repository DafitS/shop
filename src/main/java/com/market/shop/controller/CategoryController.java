package com.market.shop.controller;

import com.market.shop.mapper.CategoryMapStruct;
import com.market.shop.model.dao.Category;
import com.market.shop.model.dto.category.CategoryCreateDto;
import com.market.shop.model.dto.category.CategoryResponseDto;
import com.market.shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.MappingTarget;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryMapStruct categoryMapStruct;
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable UUID id) {
        return categoryMapStruct.mapCategoryToCategoryResponseDto(categoryService.getCategoryById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDto createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
        Category newCategory = categoryMapStruct.mapCategoryCreateDtoToCategory(categoryCreateDto);
        return categoryMapStruct.mapCategoryToCategoryResponseDto(categoryService.createCategory(newCategory));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable UUID id) {
        categoryService.deleteCategoryById(id);
    }

    @PutMapping
    public CategoryResponseDto updateCategory(CategoryCreateDto categoryCreateDto) {
        Category updateCategory = categoryMapStruct.mapCategoryCreateDtoToCategory(categoryCreateDto);
        return categoryMapStruct.mapCategoryToCategoryResponseDto(categoryService.updateCategory(updateCategory));
    }
}
