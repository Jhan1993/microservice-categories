package com.emazon.category.application.usecase;

import com.emazon.category.domain.model.Category;
import com.emazon.category.adapters.out.persistence.JpaCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ListCategoriesServiceTest {

    @Mock
    private JpaCategoryRepository jpaCategoryRepository;

    @InjectMocks
    private ListCategoriesService listCategoriesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listCategories_success() {
        Category category1 = new Category(1L, "Electronics", "All kinds of electronic items");
        Category category2 = new Category(2L, "Books", "All kinds of books");

        List<Category> categories = Arrays.asList(category1, category2);
        Pageable pageable = PageRequest.of(0, 10);
        Page<Category> page = new PageImpl<>(categories, pageable, categories.size());

        when(jpaCategoryRepository.findAll(pageable)).thenReturn(page);

        Page<Category> result = listCategoriesService.listCategories(pageable);

        assertEquals(2, result.getTotalElements());
        assertEquals(2, result.getContent().size());
    }
}