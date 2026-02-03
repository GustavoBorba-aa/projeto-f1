package com.f1.management.dto;

import com.f1.management.model.Team;

public class CreateCarDTO {

    private String modelCar;
    private Long teamId;

    public CreateCarDTO() {

    }

    public CreateCarDTO(String modelCar, Long teamId) {
        this.modelCar = modelCar;
        this.teamId = teamId;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
