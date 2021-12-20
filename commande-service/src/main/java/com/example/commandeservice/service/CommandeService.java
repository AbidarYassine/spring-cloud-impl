package com.example.commandeservice.service;

import com.example.commandeservice.entity.Commande;
import com.example.commandeservice.vo.CommandeVO;

import java.util.List;
import java.util.Optional;

public interface CommandeService extends AbstractService<Commande, Long> {

    Optional<Commande> findByReference(String reference);

    boolean existsByReference(String reference);

    List<Commande> findByTotalGreaterThan(Double total);

}
