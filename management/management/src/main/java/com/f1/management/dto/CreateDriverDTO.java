package com.f1.management.dto;

import com.f1.management.model.Team;

public class CreateDriverDTO {
    private String name;
    private String nationality;
    private int number;
    private Team team;

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getNumber() {
        return number;
    }

    public Team getTeam() {
        return team;
    }
}
