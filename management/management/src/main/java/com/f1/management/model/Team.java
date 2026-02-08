package com.f1.management.model;

import jakarta.persistence.*;

/**
 * A anotação @Entity define que esta classe é uma entidade do JPA.
 * Isso significa que ela será mapeada para uma tabela no banco de dados.
 */
@Entity
public class Team {

    /**
     * @Id indica que este campo é a chave primária da tabela.
     * @GeneratedValue define a estratégia de geração do ID.
     * IDENTITY significa que o banco de dados (como MySQL ou Postgres)
     * cuidará do auto-incremento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
    private String engine;
    private Integer foundationYear;
    private String sedeDaEquipe;
    private String chefeDeEquipe;

    /**
     * Construtor padrão (sem argumentos).
     * Essencial para o JPA, que usa reflexão para criar instâncias da classe
     * ao recuperar dados do banco.
     */
    public Team() {
    }

    /**
     * Construtor customizado para facilitar a criação de novos objetos.
     */
    public Team(String name, String country, String engine, Integer foundationYear, String sedeDaEquipe, String chefeDeEquipe) {
        this.name = name;
        this.country = country;
        this.engine = engine;
        this.foundationYear = foundationYear;
        this.sedeDaEquipe = sedeDaEquipe;
        this.chefeDeEquipe = chefeDeEquipe;
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