package com.f1.management.service;

import com.f1.management.dto.CreateResultsDTO;
import com.f1.management.model.Driver;
import com.f1.management.model.Races;
import com.f1.management.model.Results;
import com.f1.management.repository.DriverRepository;
import com.f1.management.repository.RacesRepository;
import com.f1.management.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsService {

    @Autowired
    private ResultsRepository resultsRepository;

    @Autowired
    private RacesRepository racesRepository;

    @Autowired
    private DriverRepository driverRepository;


    public Results saveFromDto(CreateResultsDTO dto) {
        if (dto.getPointsEarned() < 0 || dto.getPointsEarned() > 25) {
            throw new RuntimeException("Pontuação inválida...");
        }
        if (dto.getPosition() < 1 || dto.getPosition() > 22) {
            throw new RuntimeException("Posição Inválida...Máximo 22 carros");
        }
        Races race = racesRepository.findById(dto.getRaceId())
                .orElseThrow(() -> new RuntimeException("Corrida não encontrada com ID: " + dto.getRaceId()));

        Driver driver = driverRepository.findById(dto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Piloto não encontrado com ID: " + dto.getDriverId()));

        Results results = new Results();
        results.setRace(race);
        results.setDriver(driver);
        results.setPosition(dto.getPosition());
        results.setPointsEarned(dto.getPointsEarned());

        return resultsRepository.save(results);
    }

    public List<Results> findAll() {
        return resultsRepository.findAll();
    }

    public Results updateResults(Long id, CreateResultsDTO dto) {
        if (dto.getPointsEarned() < 0 || dto.getPointsEarned() > 25) {
            throw new RuntimeException("Pontuação inválida...");
        }
        if (dto.getPosition() < 1 || dto.getPosition() > 22) {
            throw new RuntimeException("Posição Inválida...Máximo 22 carros");
        }
        Results results = resultsRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Erro: esse resultado não existe: "));

        Races race = racesRepository.findById(dto.getRaceId())
                .orElseThrow(() -> new RuntimeException("Corrida não encontrada"));
        Driver driver = driverRepository.findById(dto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Piloto não encontrado"));

        results.setRace(race);
        results.setDriver(driver);
        results.setPosition(dto.getPosition());
        results.setPointsEarned(dto.getPointsEarned());

        return resultsRepository.save(results);
    }

    public void deleteResults(Long id) {
        if (!resultsRepository.existsById(id)) {
            throw new RuntimeException("Erro: esse ID não existe: ");
        }
        resultsRepository.deleteById(id);
    }
}