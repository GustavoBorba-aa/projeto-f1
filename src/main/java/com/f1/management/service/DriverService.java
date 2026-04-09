package com.f1.management.service;

import com.f1.management.dto.CreateDriverDTO;
import com.f1.management.model.Driver;
import com.f1.management.model.Team;
import com.f1.management.repository.DriverRepository;
import com.f1.management.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Driver saveFromDto(CreateDriverDTO dto) {

        Team team = teamRepository.findById(dto.getTeamId())
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada com ID: " + dto.getTeamId()));

        Driver driver = new Driver();
        driver.setName(dto.getName());
        driver.setNationality(dto.getNationality());
        driver.setNumber(dto.getNumber());
        driver.setTeam(team);
        driver.setCategory(dto.getCategory().trim().toUpperCase());
        driver.setAbreviacao(dto.getAbreviacao().trim().toUpperCase());

        return driverRepository.save(driver);
    }

    public Driver updateFromDto(Long id, CreateDriverDTO dto) {
        Driver driver = driverRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Esse piloto não existe: " + id));

        Team team = teamRepository.findById(dto.getTeamId())
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        driver.setName(dto.getName());
        driver.setNationality(dto.getNationality());
        driver.setNumber(dto.getNumber());
        driver.setTeam(team);
        driver.setCategory(dto.getCategory().trim().toUpperCase());
        driver.setAbreviacao(dto.getAbreviacao().trim().toUpperCase());

        return driverRepository.save(driver);
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    public void deleteDriver(Long id) {
        if (!driverRepository.existsById(id)) {
            throw new RuntimeException("erro: esse Id não existe.");
        }
        driverRepository.deleteById(id);
    }
}