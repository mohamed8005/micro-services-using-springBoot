package com.mohamed.produitservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString @Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idP;
    private String marque;
    private String desc;
    private Float prix;
    private Integer quantite;
}
