package com.hamza.demo.category;

import java.util.List;

public interface ICategory {
    Category getCategoryById(String id);
    Category addCategory(Category category);

    List<Category> getAllCategory();
    Category findCategoryByName(String name);
}
