package com.mohamed.venteservice.web;

import com.mohamed.venteservice.Produit.ProduitFindController;
import com.mohamed.venteservice.acheteur.AcheteurFindController;
import com.mohamed.venteservice.entities.Vente;
import com.mohamed.venteservice.models.Acheteur;
import com.mohamed.venteservice.models.Produit;
import com.mohamed.venteservice.repositories.VenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/api")
public class VenteController {

    @Autowired
    VenteRepository venteRepository;
    @Autowired
    AcheteurFindController acheteurFindController;
    @Autowired
    ProduitFindController produitFindController;

    @GetMapping("/vente")
    public List<Vente> getAll(){
        List<Produit> lp = produitFindController.getAll();
        List<Acheteur> la= acheteurFindController.getAll();

        List<Vente> l= venteRepository.findAll();


        for(Vente v:l){
            for(Produit p:lp) {
                if(v.getIdp()==p.getIdP()) {

                    v.setProduit(p);break;
                }
            }
            for(Acheteur a:la) {
                if(v.getIda()==a.getIdA()) {

                    v.setAcheteur(a);break;
                }
            }
        }


        return venteRepository.findAll();
    }


    @PostMapping("/vente")
    public void add(@RequestBody Vente vente){
        venteRepository.save(vente);
    }

    @PutMapping("/vente/{id}")
    public void save(@PathVariable ("id") Integer id, @RequestBody Vente a){
        Vente ar = venteRepository.findById(id).get();

        BeanUtils.copyProperties(a,ar);

        venteRepository.save(ar);
    }


    @DeleteMapping("/vente/{id}")
    public void supprimer(@PathVariable ("id") Integer id){
        venteRepository.deleteById(id);
    }


}
