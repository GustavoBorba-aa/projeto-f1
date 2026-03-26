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
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muitos resultados pertencem a uma única Corrida
    @ManyToOne
    @JoinColumn(name = "race_id")
    private Races race;

    // Muitos resultados podem pertencer a um único Piloto
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    private Integer position;
    private Double pointsEarned;
}