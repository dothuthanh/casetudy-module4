package com.casestudy.service.category;

import com.casestudy.model.AppUser;
import com.casestudy.model.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();
    Category save(Category category);

    Optional<Category> findOne(Long id);

    void remove(Long id);
}
