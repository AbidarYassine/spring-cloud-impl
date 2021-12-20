package com.example.commandeservice.mapper;

import com.example.commandeservice.entity.Commande;
import com.example.commandeservice.vo.CommandeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CommandeMapper {

    @Autowired
    private CommandeItemMapper mapper;

    public CommandeVO to(Commande commande) {
        if (commande == null) return null;
        CommandeVO commandeVO = new CommandeVO();
        commandeVO.setId(commande.getId());
        commandeVO.setDate(commande.getDate());
        commandeVO.setReference(commande.getReference());
        commandeVO.setStatus(commande.getStatus());
        commandeVO.setTotal(commande.getTotal());
        commandeVO.setTotalPaid(commande.getTotalPaid());
        commandeVO.setCommandeItems(new ArrayList<>());
        if (commande.getCommandeItems() != null)
            commande.getCommandeItems().forEach(item -> commandeVO.getCommandeItems().add(mapper.to(item)));
        return commandeVO;
    }

    public Commande to(CommandeVO commandeVO) {
        if (commandeVO == null) return null;
        Commande cmd = new Commande();
        cmd.setId(commandeVO.getId());
        cmd.setTotal(commandeVO.getTotal());
        cmd.setStatus(commandeVO.getStatus());
        cmd.setDate(commandeVO.getDate());
        cmd.setTotalPaid(commandeVO.getTotalPaid());
        cmd.setReference(commandeVO.getReference());
        return cmd;
    }
}
