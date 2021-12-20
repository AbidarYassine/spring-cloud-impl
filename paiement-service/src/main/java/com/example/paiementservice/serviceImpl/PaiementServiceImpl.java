package com.example.paiementservice.serviceImpl;

import com.example.paiementservice.entity.Paiement;
import com.example.paiementservice.repository.PaiementRepository;
import com.example.paiementservice.service.PaiementService;
import com.example.paiementservice.service.required.CommandeService;
import com.example.paiementservice.vo.CommandeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    private PaiementRepository repository;

    @Autowired
    private CommandeService commandeService;

    @Override
    public Paiement save(Paiement paiement) {
        return repository.save(paiement);
    }

    @Override
    public Optional<Paiement> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Paiement> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Paiement> findByCommande(String commandeReference) {
        if (commandeService.existsByReference(commandeReference)) return null;
        return repository.findByCommandeRef(commandeReference);
    }

    @Override
    public Paiement payer(Paiement paiement) {

        if (!commandeService.existsByReference(paiement.getCommandeRef())) return null;

        CommandeVO commandeVO = commandeService.findByReference(paiement.getCommandeRef());
        if (commandeVO.getTotalPaid() + paiement.getAmount() > commandeVO.getTotal()) return null;

        repository.save(paiement);
        commandeVO.setTotalPaid(commandeVO.getTotalPaid() + paiement.getAmount());

        if (commandeVO.getTotal().equals(commandeVO.getTotalPaid())) commandeVO.setStatus("paid");

        commandeService.update(commandeVO);

        return paiement;
    }
}
