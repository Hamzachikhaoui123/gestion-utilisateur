package com.hamza.demo.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitService implements IProduit{
    @Autowired
    ProduitRepository produitRepository;
    @Override
    public Produit addProduit(Produit request) {
        return produitRepository.save(request);    }

    @Override
    public Produit getProduitById(String id) {
        return null;
    }

    @Override
    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }
}
