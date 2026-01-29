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

    // Atributos básicos da equipe de F1
    private String name;
    private String country;
    private String engine;

    /**
     * Construtor padrão (sem argumentos).
     * Essencial para o JPA, que usa reflexão para criar instâncias da classe
     * ao recuperar dados do banco.
     */
    public Team() {
    }

    /**
     * Construtor customizado para facilitar a criação de novos objetos.
     * Nota: Não incluímos o 'id' aqui porque ele é gerado automaticamente pelo banco.
     */
    public Team(String name, String country, String engine) {
        this.name = name;
        this.country = country;
        this.engine = engine;
    }

    // --- Métodos de Acesso (Getters e Setters) ---
    // Necessários para que frameworks como o Hibernate consigam ler e injetar valores nos campos privados.

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
}