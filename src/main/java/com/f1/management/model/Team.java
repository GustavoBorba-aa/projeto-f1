package com.f1.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A anotação @Entity define que esta classe é uma entidade do JPA.
 * Isso significa que ela será mapeada para uma tabela no banco de dados.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}