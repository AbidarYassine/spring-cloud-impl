package com.example.commandeservice.serviceImpl;

import com.example.commandeservice.entity.Commande;
import com.example.commandeservice.entity.CommandeItem;
import com.example.commandeservice.repository.CommandeItemRepository;
import com.example.commandeservice.service.CommandeItemService;
import com.example.commandeservice.service.CommandeService;
import com.example.commandeservice.vo.CommandeItemVO;
import com.example.commandeservice.vo.CommandeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeItemServiceImpl implements CommandeItemService {

    @Autowired
    private CommandeItemRepository repository;

    @Autowired
    private CommandeService commandeService;

    @Override
    public CommandeItem save(CommandeItem commandeItem) {
        return repository.save(commandeItem);
    }

    @Override
    public Optional<CommandeItem> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<CommandeItem> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<CommandeItem> findByCommande(String commandeReference) {
        Commande commande = commandeService.findByReference(commandeReference).orElse(null);
        return commande == null ? null : repository.findByCommande(commande);
    }

    @Override
    public Commande createCommande(CommandeVO commandeVO) {
        Commande c = new Commande();
        c.setDate(new Date());
        c.setReference(commandeVO.getReference());
        c.setStatus(commandeVO.getStatus());
        c.setTotal(commandeVO.getTotal());
        c.setTotalPaid(0d);
        Commande saved = commandeService.save(c);

        for (CommandeItemVO commandeItemVO : commandeVO.getCommandeItems()) {
            CommandeItem item = new CommandeItem();
            item.setCommande(saved);
            item.setProduitId(commandeItemVO.getProduitId());
            item.setQte(commandeItemVO.getQte());
            repository.save(item);
        }

        return commandeService.save(saved);
    }
}
