package com.casestudy.repository.category;

import com.casestudy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;

@Repository
public interface ICategory extends JpaRepository<Category, Long> {

}
