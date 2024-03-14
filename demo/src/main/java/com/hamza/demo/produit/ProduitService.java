package com.hamza.demo.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ProduitService implements IProduit{
    @Autowired
    ProduitRepository produitRepository;
    @Override
    public Produit addProduit(Produit request) {
        request.setDateCreation(new Date());
        return produitRepository.save(request);    }

    @Override
    public Produit getProduitById(String id) {
        return produitRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }

    @Override
    public Produit updatePatient(String id, Produit produit) {
        Produit produitUpdate= getProduitById(id);
        produitUpdate.setName(produit.getName());
        produitUpdate.setPrice(produit.getPrice());
        produitUpdate.setRef(produit.getRef());
        return produitRepository.save(produitUpdate);
    }

    @Override
        public Produit deleteProduit(String id) {
        produitRepository.deleteById(id);
        return null;
    }
}
