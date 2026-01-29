package com.f1.management.model;

import jakarta.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    private int number;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    // (obrigatório para o JPA)
    public Driver() {

    }

    // Construtor completo (útil para o banco carregar dados existentes)
    public Driver(Long id, String name, String nationality, int number, Team team) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.number = number;
        this.team = team;
    }

    // NOVO CONSTRUTOR (Para você usar no Controller ao criar novos pilotos)
    public Driver(String name, String nationality, int number, Team team) {
        this.name = name;
        this.nationality = nationality;
        this.number = number;
        this.team = team;
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
}