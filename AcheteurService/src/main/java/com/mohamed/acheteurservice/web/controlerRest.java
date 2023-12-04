package com.mohamed.acheteurservice.web;


import com.mohamed.acheteurservice.entities.Acheteur;
import com.mohamed.acheteurservice.model.Produit;
import com.mohamed.acheteurservice.produit.ProduitFindController;
import com.mohamed.acheteurservice.respositories.AcheteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
public class controlerRest {

    @Autowired
    private ProduitFindController produitFindController;


    @Autowired
    AcheteurRepository acheteurRepository;

    @GetMapping("/acheteurs")
    public List<Acheteur> getAll(){
        List<Produit> lp = produitFindController.getAll();
        List<Acheteur> l= acheteurRepository.findAll();

        for(Acheteur a:l){
            for(Produit p:lp) {
                if(a.getIdProduit()==p.getIdP()) {

                    a.setProduit(p);break;
                }
            }
        }
        return l;
    }

    @GetMapping("/acheteurs/{id}")
    public Acheteur getById(@PathVariable ("id") Integer id){


        Acheteur e= acheteurRepository.findById(id).get();
        Produit p = produitFindController.getById(e.getIdProduit());

        e.setProduit(p);
        return  e;
    }

    @PutMapping("/acheteurs/{id}")
    public void save(@PathVariable ("id") Integer id, @RequestBody Acheteur a){
        Acheteur ar = acheteurRepository.findById(id).get();

        if(a.getNom()!=null) {ar.setNom(a.getNom());}
        if(a.getVille()!=null){ar.setVille(a.getVille());}

        acheteurRepository.save(ar);
    }

    @PostMapping("/acheteurs")
    public void add(@RequestBody Acheteur a){
        acheteurRepository.save(a);
    }

    @DeleteMapping("/acheteurs/{id}")
    public void supprimer(@PathVariable ("id") Integer id){
        acheteurRepository.deleteById(id);
    }

}