package com.example.paiementservice.mapper;

import com.example.paiementservice.entity.Paiement;
import com.example.paiementservice.vo.PaiementVO;
import org.springframework.stereotype.Component;

@Component
public class PaiementMapper {

    public PaiementVO to(Paiement paiement) {
        if (paiement == null) return null;
        PaiementVO paiementVO = new PaiementVO();
        paiementVO.setId(paiement.getId());
        paiementVO.setDate(paiement.getDate());
        paiementVO.setAmount(paiement.getAmount());
        paiementVO.setType(paiement.getType());
        paiementVO.setCommandeRef(paiement.getCommandeRef());
        return paiementVO;
    }

    public Paiement to(PaiementVO paiementVO) {
        if (paiementVO == null) return null;
        Paiement paiement = new Paiement();
        paiement.setId(paiementVO.getId());
        paiement.setType(paiementVO.getType());
        paiement.setDate(paiementVO.getDate());
        paiement.setAmount(paiementVO.getAmount());
        paiement.setCommandeRef(paiementVO.getCommandeRef());
        return paiement;
    }

}
