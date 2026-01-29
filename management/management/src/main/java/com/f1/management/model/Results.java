package com.f1.management.model;

import jakarta.persistence.*;

@Entity
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

    public Results() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Races getRace() {
        return race;
    }

    public void setRace(Races race) {
        this.race = race;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Double getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(Double pointsEarned) {
        this.pointsEarned = pointsEarned;
    }
}