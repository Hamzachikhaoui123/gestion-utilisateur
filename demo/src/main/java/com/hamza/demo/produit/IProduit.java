package com.hamza.demo.produit;

import java.util.List;

public interface IProduit {

    Produit addProduit(Produit produit);
    Produit getProduitById(String id);
    List<Produit> getAllProduit();
}
