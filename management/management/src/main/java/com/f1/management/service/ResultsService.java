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
        // Busca as entidades reais pelos IDs vindos do DTO
        Races race = racesRepository.findById(dto.getRaceId())
                .orElseThrow(() -> new RuntimeException("Corrida não encontrada com ID: " + dto.getRaceId()));

        Driver driver = driverRepository.findById(dto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Piloto não encontrado com ID: " + dto.getDriverId()));

        // Mapeia os dados para a entidade Results
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
        Results results = resultsRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Erro: esse resultado não existe: "));

        // Se quiser mudar o piloto ou a corrida na atualização:
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

    // Método de exclusão (DELETE)
    public void deleteResults(Long id) {
        if (!resultsRepository.existsById(id)) {
            throw new RuntimeException("Erro: esse ID não existe: ");
        }
        resultsRepository.deleteById(id);
    }
}