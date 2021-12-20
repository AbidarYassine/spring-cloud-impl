package com.example.commandeservice.repository;

import com.example.commandeservice.entity.Commande;
import com.example.commandeservice.entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeItemRepository extends JpaRepository<CommandeItem, Long> {

    List<CommandeItem> findByCommande(Commande commande);

}
