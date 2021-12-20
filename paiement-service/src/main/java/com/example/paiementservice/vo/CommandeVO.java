package com.example.paiementservice.vo;

import java.util.Date;
import java.util.List;

public class CommandeVO {

    private Long id;
    private String reference;
    private String status;
    private Double total;
    private Double totalPaid;
    private Date date;
    private List<CommandeItemVO> commandeItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<CommandeItemVO> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItemVO> commandeItems) {
        this.commandeItems = commandeItems;
    }
}
