package com.example.paiementservice.vo;

import java.util.Date;

public class PaiementVO {

    private Long id;

    private String commandeRef;
    private Double amount;
    private String type;
    private Date date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommandeRef() {
        return commandeRef;
    }

    public void setCommandeRef(String commandeRef) {
        this.commandeRef = commandeRef;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
