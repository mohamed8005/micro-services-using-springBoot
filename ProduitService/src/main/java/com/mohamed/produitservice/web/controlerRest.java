package com.mohamed.produitservice.web;



import com.mohamed.produitservice.config.GlobalConfig;
import com.mohamed.produitservice.config.ProduitConfig;
import com.mohamed.produitservice.entities.Produit;
import com.mohamed.produitservice.respositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")
public class controlerRest {




    @Autowired
    ProduitRepository acheteurRepository;

    @Autowired
    GlobalConfig globalConfig;

    @Autowired
    ProduitConfig produitConfig;

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }

    @GetMapping("/produitConfig")
    public ProduitConfig produitConfig(){
        return produitConfig;
    }

    @GetMapping("/produits")
    public List<Produit> getAll(){
        return  acheteurRepository.findAll();

    }

    @GetMapping("/produits/{id}")
    public Produit getById(@PathVariable ("id") Integer id){


        return acheteurRepository.findById(id).get();

    }

    @PutMapping("/produits/{id}")
    public void save(@PathVariable ("id") Integer id, @RequestBody Produit a){
        a.setIdP(id);

        acheteurRepository.save(a);
    }

    @PostMapping("/produits")
    public void add(@RequestBody Produit a){
        acheteurRepository.save(a);
    }

    @DeleteMapping("/produits/{id}")
    public void supprimer(@PathVariable ("id") Integer id){
        acheteurRepository.deleteById(id);
    }

}