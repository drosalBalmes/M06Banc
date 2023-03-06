package com.example.m06bancproject.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nom;
    @Column
    private String DNI;
    @Column
    private String email;
    @Column
    private String pais;

    @OneToMany(mappedBy = "client")
    private List<Compte> comptes;

    private int ingres;


    public Client(long id, String nom, String DNI, String email, String pais, List<Compte> comptes) {
        this.id = id;
        this.nom = nom;
        this.DNI = DNI;
        this.email = email;
        this.pais = pais;
        this.comptes = comptes;
    }

    public Client(String nom, String DNI, String email, String pais, List<Compte> comptes, int ingres) {
        this.nom = nom;
        this.DNI = DNI;
        this.email = email;
        this.pais = pais;
        this.comptes = comptes;
        this.ingres = ingres;
    }

    public Client(String nom, String DNI, String email, String pais, int ingres) {
        this.nom = nom;
        this.DNI = DNI;
        this.email = email;
        this.pais = pais;
        this.ingres = ingres;
    }

    public Client(String nom, String DNI, String email, String pais, List<Compte> comptes) {
        this.nom = nom;
        this.DNI = DNI;
        this.email = email;
        this.pais = pais;
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", DNI='" + DNI + '\'' +
                ", email='" + email + '\'' +
                ", pais='" + pais + '\'' +
                ", comptes=" + comptes +
                '}';
    }
}
