package com.f1.management.dto;

public class CreateResultsDTO {
    private Long raceId;    // Apenas o ID da Corrida
    private Long driverId;  // Apenas o ID do Piloto
    private Integer position;
    private Double pointsEarned;

    public CreateResultsDTO() {

    }
    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
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