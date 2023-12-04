package com.mohamed.acheteurservice.entities;

import com.mohamed.acheteurservice.model.Produit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString @Data
public class Acheteur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idA;
    private String nom;
    @Enumerated(EnumType.STRING)
    private Ville ville;

    private Integer idProduit;
    @Transient
    private Produit produit;
}
