package com.example.m06bancproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compte {

    @Id
    @Column
    private String iban;
    @Column
    private int saldo;

    @ManyToOne
    private Client client;

    public Compte(String iban, int saldo, Client client) {
        this.iban = iban;
        this.saldo = saldo;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "iban='" + iban + '\'' +
                ", saldo=" + saldo +
                ", client=" + client +
                '}';
    }
}
