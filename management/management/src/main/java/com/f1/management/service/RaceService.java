package com.f1.management.service;

import com.f1.management.dto.CreateRacesDTO;
import com.f1.management.model.Races;
import com.f1.management.repository.RacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RaceService {

    @Autowired
    private RacesRepository racesRepository;

    public Races saveRaces(CreateRacesDTO dto) {
        if (dto.getNameCircuit() == null || dto.getNameCircuit().isBlank()){
            throw new RuntimeException("O nome do Circuito não pode estar vazio...");
        }
        if (dto.getGrandPrixName() == null || dto.getGrandPrixName().isBlank()){
            throw new RuntimeException("O nome do Grand Prix não pode estar vazio...");
        }
        if (dto.getRaceDate() == null){
            throw new RuntimeException("A data não pode estar vazia...");
        }
        if (dto.getRaceDate().isAfter(LocalDate.now())){
            throw new RuntimeException("Não é possível cadastrar resultados de uma corrida que ainda não aconteceu!");
        }
        Races races = new Races(
                dto.getNameCircuit(),
                dto.getGrandPrixName(),
                dto.getRaceDate()
        );
        return racesRepository.save(races);
    }

    public List<Races> findAll() {
        return racesRepository.findAll();
    }

    public Races updateRaces(Long id, CreateRacesDTO dto) {
        if (dto.getNameCircuit() == null || dto.getNameCircuit().isBlank()){
            throw new RuntimeException("O nome do Circuito não pode estar vazio...");
        }
        if (dto.getGrandPrixName() == null || dto.getGrandPrixName().isBlank()){
            throw new RuntimeException("O nome do Grand Prix não pode estar vazio...");
        }
        if (dto.getRaceDate() == null){
            throw new RuntimeException("A data não pode estar vazia...");
        }
        if (dto.getRaceDate().isAfter(LocalDate.now())){
            throw new RuntimeException("Não é possível cadastrar resultados de uma corrida que ainda não aconteceu!");
        }
        Races races = racesRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Erro: essa corrida não existe: "));

        races.setRaceDate(dto.getRaceDate());
        races.setGrandPrixName(dto.getGrandPrixName());
        races.setNameCircuit(dto.getNameCircuit());

        return racesRepository.save(races);
    }

    public void deleteRaces(Long id) {
        if (!racesRepository.existsById(id)) {
            throw new RuntimeException("Erro: esse ID não existe.");
        }
        racesRepository.deleteById(id);
    }
}