package com.mohamed.acheteurservice;

import com.mohamed.acheteurservice.entities.Acheteur;
import com.mohamed.acheteurservice.entities.Ville;
import com.mohamed.acheteurservice.respositories.AcheteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;
@EnableFeignClients
@SpringBootApplication
public class AcheteurServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcheteurServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AcheteurRepository acheteurRepository){
        return args -> {
            acheteurRepository.save(Acheteur.builder()
                    .nom("Ali Mohammed")
                    .ville(Ville.Rabat).idProduit(1)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Khaoula Jadimoussa")
                    .ville(Ville.Rabat).idProduit(2)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Salem salem")
                    .ville(Ville.Rabat)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Aya aya")
                    .ville(Ville.Rabat)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Jack Pattinson")
                    .ville(Ville.Rabat)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Ahmad Khan")
                    .ville(Ville.Rabat)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Michel Duchamps")
                    .ville(Ville.Rabat)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Julia Robert")
                    .ville(Ville.Rabat)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Djamel ALI")
                    .ville(Ville.Rabat)
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Luisa Clarck")
                    .ville(Ville.Rabat)
                    .build());

            List<Acheteur> liste = acheteurRepository.findAll();

            for (Acheteur a:liste){
                System.out.println("*************************");
                System.out.println(a.getNom());
                System.out.println(a.getVille());
            }

        };
    }
}
