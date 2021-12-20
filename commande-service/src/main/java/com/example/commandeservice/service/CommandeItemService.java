package com.example.commandeservice.service;

import com.example.commandeservice.entity.Commande;
import com.example.commandeservice.entity.CommandeItem;
import com.example.commandeservice.vo.CommandeVO;

import java.util.List;

public interface CommandeItemService extends AbstractService<CommandeItem, Long> {
    List<CommandeItem> findByCommande(String commandeReference);
    Commande createCommande(CommandeVO commandeVO);
}
