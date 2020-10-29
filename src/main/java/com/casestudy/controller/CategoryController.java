package com.casestudy.controller;

import com.casestudy.model.Category;
import com.casestudy.service.category.ICategoryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private Environment environment;
    @GetMapping("/categories")
    public ModelAndView showCategory() {
        Iterable<Category> categories = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }
//    @PostMapping("/create")
//        public ModelAndView createCategory(@ModelAttribute("category") Category category) {
//        iCategoryService.save(category);
//        ModelAndView modelAndView = new ModelAndView("/category/create");
//        modelAndView.addObject("category" , new Category());
//        return modelAndView;
//        }
    @PostMapping("/create")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        MultipartFile file = category.getAvatar();
        String image = file.getOriginalFilename();
        category.setImg(image);
        String fileUpload = environment.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        iCategoryService.save(category);
        return new ModelAndView("/category/create", "category", category);
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id)  {
       Optional<Category> category = iCategoryService.findOne(id);
        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category",category);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/category/loi");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {

        category.setId(category.getId());
        if(category.getImg().equals("")){
            MultipartFile file = category.getAvatar();
            String image = file.getOriginalFilename();
            category.setImg(image);
            String fileUpload = environment.getProperty("file_upload").toString();
            try {
                FileCopyUtils.copy(file.getBytes(), new File(fileUpload + image));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        iCategoryService.save(category);
        return new ModelAndView("/category/edit", "category", new Category());

    }
//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//       Optional<Category> category = iCategoryService.findOne(id);
//        if(category != null) {
//            ModelAndView modelAndView = new ModelAndView("/category/delete");
//            modelAndView.addObject("category", category);
//            return modelAndView;
//
//        }else {
////            ModelAndView modelAndView = new ModelAndView("/error.404");
//            ModelAndView modelAndView = new ModelAndView("/category/loi");
//            return modelAndView;
//        }
//    }
    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id){
        Optional<Category> category = iCategoryService.findOne(id);
        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category",category);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/category/loi");
            return modelAndView;
        }
    }
    @PostMapping("/delete")
    public String deleteCategory(@ModelAttribute("category") Category category) {
        iCategoryService.remove(category.getId());
        return "redirect:categories";
    }
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/category/exption");
    }




}