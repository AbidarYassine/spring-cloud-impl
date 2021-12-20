package com.example.paiementservice.wsRest;

import com.example.paiementservice.mapper.PaiementMapper;
import com.example.paiementservice.service.PaiementService;
import com.example.paiementservice.vo.PaiementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("")
public class PaiementRest {

    @Autowired
    private PaiementService paiementService;

    @Autowired
    private PaiementMapper paiementMapper;

    @PostMapping("/payer")
    public PaiementVO payer(@RequestBody PaiementVO paiementVO) {
        return paiementMapper.to(paiementService.payer(paiementMapper.to(paiementVO)));
    }

    @GetMapping("/{id}")
    public PaiementVO findById(@PathVariable Long id) {
        return paiementService.findById(id).map(paiementMapper::to).orElse(null);
    }

    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable Long id) {
        return paiementService.existsById(id);
    }

    @GetMapping("/all")
    public List<PaiementVO> findAll() {
        return paiementService.findAll().stream().map(paiementMapper::to).collect(Collectors.toList());
    }

    @GetMapping("/all/commande/{ref}")
    public List<PaiementVO> findByCommande(@PathVariable String ref) {
        return paiementService.findByCommande(ref).stream().map(paiementMapper::to).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paiementService.delete(id);
    }

}

