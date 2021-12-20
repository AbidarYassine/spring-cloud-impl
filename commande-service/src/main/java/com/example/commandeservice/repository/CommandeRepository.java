package com.example.commandeservice.repository;

import com.example.commandeservice.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

    Optional<Commande> findByReference(String reference);

    boolean existsByReference(String reference);

    List<Commande> findByTotalGreaterThan(Double total);
}
