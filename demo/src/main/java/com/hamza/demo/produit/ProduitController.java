package com.hamza.demo.produit;

import com.hamza.demo.category.Category;
import com.hamza.demo.category.ICategory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produit")
@RequiredArgsConstructor
public class ProduitController {
    @Autowired
    ICategory iCategory;
    @Autowired
    IProduit iProduit;

    @PostMapping(path = "add/{id}")
   public Produit addProduit(@RequestBody Produit body , @PathVariable String id){
        Category category=iCategory.getCategoryById(id);
        body.setCategory(category);
        return iProduit.addProduit(body);

    }
}