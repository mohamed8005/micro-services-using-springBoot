package com.mohamed.venteservice.repositories;

import com.mohamed.venteservice.entities.Vente;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface VenteRepository extends JpaRepository<Vente,Integer> {
}
