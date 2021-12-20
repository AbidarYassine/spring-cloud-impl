package com.example.paiementservice.service.required;

import com.example.paiementservice.vo.CommandeVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("http://COMMANDE-SERVICE/api/v1/")
public interface CommandeService {

    @GetMapping("/{id}")
    CommandeVO findById(@PathVariable Long id);

    @GetMapping("/exists/{id}")
    boolean existsById(@PathVariable Long id);

    @GetMapping("/exists/reference/{reference}")
    boolean existsByReference(@PathVariable String reference);

    @GetMapping("/reference/{reference}")
    CommandeVO findByReference(@PathVariable String reference);

    @PutMapping("/")
    CommandeVO update(@RequestBody CommandeVO commandeVO);

}
