package com.emazon.category.domain.port.out;


import com.emazon.category.domain.model.Category;

import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findByName(String name);
    Category save(Category category);
}
