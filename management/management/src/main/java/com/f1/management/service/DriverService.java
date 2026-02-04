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
        // Busca a equipe pelo ID (Long) que vem diretamente do DTO
        Team team = teamRepository.findById(dto.getTeamId())
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada com ID: " + dto.getTeamId()));

        Driver driver = new Driver();
        driver.setName(dto.getName());
        driver.setNationality(dto.getNationality());
        driver.setNumber(dto.getNumber());
        driver.setTeam(team); // Vincula o objeto Team completo ao Piloto

        return driverRepository.save(driver);
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }


    public Driver updateFromDto(Long id, CreateDriverDTO dto) {
        Driver driver = driverRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Esse piloto não existe: " + id));

        Team team = teamRepository.findById(dto.getTeamId())         // Busca a nova equipe pelo ID do DTO
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        driver.setName(dto.getName());
        driver.setNationality(dto.getNationality());
        driver.setNumber(dto.getNumber());
        driver.setTeam(team);

        return driverRepository.save(driver);
    }

    public void deleteDriver(Long id) {
        if (!driverRepository.existsById(id)) {
            throw new RuntimeException("erro: esse Id não existe.");
        }
        driverRepository.deleteById(id);
    }
}