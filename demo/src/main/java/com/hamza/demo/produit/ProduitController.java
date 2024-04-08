package com.hamza.demo.produit;

import com.hamza.demo.category.Category;
import com.hamza.demo.category.ICategory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produit")
@RequiredArgsConstructor
public class ProduitController {
    @Autowired
    ICategory iCategory;
    @Autowired
    IProduit iProduit;
    @Autowired
    private ProduitService produitService;
    @PostMapping(path = "add/{id}")
    public Produit addProduit(@RequestBody Produit body, @PathVariable String id) {
        Category category = iCategory.getCategoryById(id);
        body.setCategory(category);
        return iProduit.addProduit(body);

    }

    @PutMapping(path = "edit/{id}")
    public  Produit editProduit(@RequestBody Produit request,@PathVariable String id){
        return produitService.updatePatient(id,request);
    }

    @GetMapping(path = "/all")
    public List<Produit> getAllUser(){
        return iProduit.getAllProduit();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Produit> deleteProduit(@PathVariable  String id){

        return ResponseEntity.ok(produitService.deleteProduit(id));
    }
}
