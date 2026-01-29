package com.f1.management.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelCar;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Car() {

    }

    public Car(Long id, String modelCar, Team team) {
        this.id = id;
        this.modelCar = modelCar;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
