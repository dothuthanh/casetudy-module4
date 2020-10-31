package com.casestudy.service.category;

import com.casestudy.model.AppUser;
import com.casestudy.model.Category;
import com.casestudy.repository.category.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategory iCategory;
    @Override
    public Page<Category> findAll(Pageable pageable) {
//        pageable = PageRequest.of(2,10);
        return iCategory.findAll(pageable);
    }
    @Override
    public Category save(Category category) {
        return iCategory.save(category);
    }

    @Override
    public Optional<Category> findOne(Long id) {
            Optional<Category> category = iCategory.findById(id);
            return category;
    }

    @Override
    public void remove(Long id) {
        iCategory.deleteById(id);

    }


}
