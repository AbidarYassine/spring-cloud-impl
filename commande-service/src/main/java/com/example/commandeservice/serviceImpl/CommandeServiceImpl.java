package com.example.commandeservice.serviceImpl;

import com.example.commandeservice.entity.Commande;
import com.example.commandeservice.repository.CommandeRepository;
import com.example.commandeservice.service.CommandeItemService;
import com.example.commandeservice.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepository repository;

    @Override
    public Commande save(Commande commande) {
        return repository.save(commande);
    }

    @Override
    public Optional<Commande> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Commande> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Commande> findByReference(String reference) {
        return repository.findByReference(reference);
    }

    @Override
    public boolean existsByReference(String reference) {
        return repository.existsByReference(reference);
    }

    @Override
    public List<Commande> findByTotalGreaterThan(Double total) {
        return repository.findByTotalGreaterThan(total);
    }

}
