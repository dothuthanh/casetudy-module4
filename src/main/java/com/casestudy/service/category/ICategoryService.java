package com.casestudy.service.category;

import com.casestudy.model.AppUser;
import com.casestudy.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);
    Category save(Category category);

    Optional<Category> findOne(Long id);

    void remove(Long id);

}
