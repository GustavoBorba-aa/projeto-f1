package com.f1.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.time.LocalDate;

@Entity
public class Races {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCircuit;
    private String grandPrixName;
    private LocalDate raceDate;

    public Races() {

    }

    public Races(Long id, String nameCircuit, String grandPrixName, LocalDate raceDate) {
        this.id = id;
        this.nameCircuit = nameCircuit;
        this.grandPrixName = grandPrixName;
        this.raceDate = raceDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCircuit() {
        return nameCircuit;
    }

    public void setNameCircuit(String nameCircuit) {
        this.nameCircuit = nameCircuit;
    }

    public String getGrandPrixName() {
        return grandPrixName;
    }

    public void setGrandPrixName(String grandPrixName) {
        this.grandPrixName = grandPrixName;
    }

    public LocalDate getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(LocalDate raceDate) {
        this.raceDate = raceDate;
    }
}
