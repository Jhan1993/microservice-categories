package com.emazon.category.domain.port.in;

import com.emazon.category.domain.model.Category;

public interface CreateCategoryUseCase {
    Category createCategory(Category category);
}
