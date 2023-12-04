package com.mohamed.acheteurservice.produit;

import com.mohamed.acheteurservice.model.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PRODUIT-SERVICE")
public interface ProduitFindController {

    @GetMapping("/api/produits")
    public List<Produit> getAll();

    @GetMapping("/api/produits/{idP}")
    public Produit getById(@PathVariable Integer idP);
}
