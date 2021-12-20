package com.example.commandeservice.wsRest;

import com.example.commandeservice.mapper.CommandeItemMapper;
import com.example.commandeservice.mapper.CommandeMapper;
import com.example.commandeservice.service.CommandeItemService;
import com.example.commandeservice.service.CommandeService;
import com.example.commandeservice.vo.CommandeItemVO;
import com.example.commandeservice.vo.CommandeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("")
public class CommandeRest {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private CommandeItemService commandeItemService;

    @Autowired
    private CommandeMapper commandeMapper;

    @Autowired
    private CommandeItemMapper commandeItemMapper;

    @PostMapping("/")
    public CommandeVO create(@RequestBody CommandeVO commandeVO) {
        return commandeMapper.to(commandeItemService.createCommande(commandeVO));
    }

    @PutMapping("/")
    public CommandeVO update(@RequestBody CommandeVO commandeVO) {
        return commandeMapper.to(commandeService.save(commandeMapper.to(commandeVO)));
    }

    @GetMapping("/{id}")
    public CommandeVO findById(@PathVariable Long id) {
        return commandeService.findById(id).map(commandeMapper::to).orElse(null);
    }

    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable Long id) {
        return commandeService.existsById(id);
    }

    @GetMapping("/exists/reference/{reference}")
    public boolean existsByReference(@PathVariable String reference) {
        return commandeService.existsByReference(reference);
    }

    @GetMapping("/reference/{reference}")
    public CommandeVO findByReference(@PathVariable String reference) {
        return commandeService.findByReference(reference).map(commandeMapper::to).orElse(null);
    }

    @GetMapping("/all")
    public List<CommandeVO> findAll() {
        return commandeService.findAll().stream().map(commandeMapper::to).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commandeService.delete(id);
    }

    @GetMapping("/total/min/{total}")
    public List<CommandeVO> findByTotalGreaterThan(@PathVariable Double total) {
        return commandeService.findByTotalGreaterThan(total).stream().map(commandeMapper::to).collect(Collectors.toList());
    }

    @GetMapping("/item/{id}")
    public CommandeItemVO findByItemId(@PathVariable Long id) {
        return commandeItemService.findById(id).map(commandeItemMapper::to).orElse(null);
    }

    @GetMapping("/item/exists/{id}")
    public boolean existsByItemId(@PathVariable Long id) {
        return commandeItemService.existsById(id);
    }

    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable Long id) {
        commandeItemService.delete(id);
    }

    @GetMapping("/all/items")
    public List<CommandeItemVO> findAllItems() {
        return commandeItemService.findAll().stream().map(commandeItemMapper::to).collect(Collectors.toList());
    }

    @GetMapping("/{reference}/items")
    public List<CommandeItemVO> findByCommande(@PathVariable String reference) {
        return commandeItemService.findByCommande(reference).stream().map(commandeItemMapper::to).collect(Collectors.toList());
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
