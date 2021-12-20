package com.example.commandeservice.mapper;

import com.example.commandeservice.entity.CommandeItem;
import com.example.commandeservice.vo.CommandeItemVO;
import org.springframework.stereotype.Component;

@Component
public class CommandeItemMapper {

    public CommandeItemVO to(CommandeItem commandeItem) {
        CommandeItemVO commandeItemVO = new CommandeItemVO();
        commandeItemVO.setId(commandeItem.getId());
        commandeItemVO.setProduitId(commandeItem.getProduitId());
        commandeItemVO.setQte(commandeItem.getQte());
        return commandeItemVO;
    }

}
