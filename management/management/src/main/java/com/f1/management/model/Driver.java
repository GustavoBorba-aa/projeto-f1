package com.f1.management.model;

import jakarta.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    private String category;
    private String abreviacao;


    @Column(name = "number_car", nullable = false)
    private int number;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    // Construtor padrão (obrigatório para o JPA)
    public Driver() {
    }


    public Driver(Long id, String name, String nationality, int number, Team team, String category, String abreviacao) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.number = number;
        this.team = team;
        this.category = category;
        this.abreviacao = abreviacao;
    }

    public Driver(String name, String nationality, int number, Team team, String category, String abreviacao) {
        this.name = name;
        this.nationality = nationality;
        this.number = number;
        this.team = team;
        this.category = category;
        this.abreviacao = abreviacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Team getTeam() {

        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }
}