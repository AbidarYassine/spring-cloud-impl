package com.example.paiementservice.service;

import com.example.paiementservice.entity.Paiement;

import java.util.List;

public interface PaiementService extends AbstractService<Paiement, Long> {

    List<Paiement> findByCommande(String commandeReference);

    Paiement payer(Paiement paiement);
}
