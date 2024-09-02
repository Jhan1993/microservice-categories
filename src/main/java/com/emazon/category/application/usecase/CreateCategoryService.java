package com.emazon.category.application.usecase;

import com.emazon.category.domain.model.Category;
import com.emazon.category.domain.port.in.CreateCategoryUseCase;
import com.emazon.category.domain.port.out.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateCategoryService implements CreateCategoryUseCase {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CreateCategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category){
        Optional<Category> existingCategory = categoryRepository.findByName(category.getName());
        if(existingCategory.isPresent()){
            throw new IllegalArgumentException("Ya existe una categoria con el mismo nombre.");
        }
        return categoryRepository.save(category);
    }
}
