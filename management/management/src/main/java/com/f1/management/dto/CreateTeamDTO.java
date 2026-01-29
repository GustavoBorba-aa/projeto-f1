// Exemplo de como deve estar o seu DTO
package com.f1.management.dto;

public class CreateTeamDTO {
    private String name;
    private String country;
    private String engine;

    // Getters são fundamentais aqui!
    public String getName() {
        return name; }
    public String getCountry()
    { return country; }
    public String getEngine()
    { return engine; }
}