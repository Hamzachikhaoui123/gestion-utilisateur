package com.hamza.demo.category;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private  CategoryService categoryService;
    @Autowired
    private ICategory iCategory;
    @PostMapping("")
    public ResponseEntity<Category>addCateogry(@RequestBody Category body){
        return ResponseEntity.ok(categoryService.addCategory(body));
    }

    @GetMapping("")

    public List<Category> getAllCategory(){
        return iCategory.getAllCategory();
    }

   @GetMapping( "/filter")
    public  Category filterCategory(@RequestParam String name){
        System.out.println(name);
        return categoryService.findCategoryByName(name);
   }
}
