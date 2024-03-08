package com.hamza.demo.category;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private  CategoryService categoryService;
    @PostMapping("")
    public ResponseEntity<Category>addCateogry(@RequestBody Category body){
        return ResponseEntity.ok(categoryService.addCategory(body));
    }
}
