package com.mohamed.acheteurservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString @Data
public class Produit {


    private Integer idP;
    private String marque;
    private String desc;
    private Float prix;
    private Integer quantite;
}
