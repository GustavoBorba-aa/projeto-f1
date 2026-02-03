package com.f1.management.dto;

import java.time.LocalDate;

public class CreateRacesDTO {
    private String nameCircuit;
    private String grandPrixName;
    private LocalDate raceDate;

    public CreateRacesDTO() {
    }

    public CreateRacesDTO(String nameCircuit, String grandPrixName, LocalDate raceDate) {
        this.nameCircuit = nameCircuit;
        this.grandPrixName = grandPrixName;
        this.raceDate = raceDate;
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
