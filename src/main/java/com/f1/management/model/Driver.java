package com.f1.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String nationality;
    private String category;
    private String abreviacao;


    @Column(name = "number_car", nullable = false)
    private int number;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}