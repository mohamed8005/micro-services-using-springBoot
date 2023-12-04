package com.mohamed.venteservice.entities;


import com.mohamed.venteservice.models.Acheteur;
import com.mohamed.venteservice.models.Produit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Vente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer ida;
    private Integer idp;
    private Integer quantite;
    private Integer mois;
    private Integer annee;
    @Transient
    private Acheteur acheteur;
    @Transient
    private Produit produit;

}
