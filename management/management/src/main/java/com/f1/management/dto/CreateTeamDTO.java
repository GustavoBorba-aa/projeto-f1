// Exemplo de como deve estar o seu DTO
package com.f1.management.dto;

public class CreateTeamDTO {
    private String name;
    private String country;
    private String engine;
    private Integer foundationYear;
    private String sedeDaEquipe;
    private String chefeDeEquipe;

    // Getters são fundamentais aqui!


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Integer foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getSedeDaEquipe() {
        return sedeDaEquipe;
    }

    public void setSedeDaEquipe(String sedeDaEquipe) {
        this.sedeDaEquipe = sedeDaEquipe;
    }

    public String getChefeDeEquipe() {
        return chefeDeEquipe;
    }

    public void setChefeDeEquipe(String chefeDeEquipe) {
        this.chefeDeEquipe = chefeDeEquipe;
    }
}