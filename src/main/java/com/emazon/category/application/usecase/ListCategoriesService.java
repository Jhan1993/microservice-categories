package com.emazon.category.application.usecase;

import com.emazon.category.domain.model.Category;
import com.emazon.category.adapters.out.persistence.JpaCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListCategoriesService {

    private final JpaCategoryRepository jpaCategoryRepository;

    @Autowired
    public ListCategoriesService(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    public Page<Category> listCategories(Pageable pageable) {
        return jpaCategoryRepository.findAll(pageable);
    }
}
