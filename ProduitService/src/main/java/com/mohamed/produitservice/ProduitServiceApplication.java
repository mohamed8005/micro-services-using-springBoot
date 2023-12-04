package com.mohamed.produitservice;

import com.mohamed.produitservice.config.GlobalConfig;
import com.mohamed.produitservice.config.ProduitConfig;
import com.mohamed.produitservice.entities.Produit;
import com.mohamed.produitservice.respositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class, ProduitConfig.class})
public class ProduitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProduitRepository produitRepository){
        return args -> {
            for(int i=0;i<10;i++){
                Produit p=Produit.builder().marque("abibas").desc("andjzbdjzbdjz").prix((Float) ((float) (Math.random()*1000))).quantite(100).build();
                produitRepository.save(p);
            }

            List<Produit> l=produitRepository.findAll();


            for(Produit p :l){
                System.out.println("===============================");
                System.out.println(p.getIdP());
                System.out.println(p.getMarque());
                System.out.println(p.getPrix());


            }
        };
    }
}
