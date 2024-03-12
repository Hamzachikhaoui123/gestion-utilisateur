package com.hamza.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService  implements  ICategory{
@Autowired
private CategoryRepository categoryRepository;


    @Override
    public Category getCategoryById(String id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public Category addCategory(Category category) {
        var cateorgy=Category.builder().name(category.getName()).build();
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
}
