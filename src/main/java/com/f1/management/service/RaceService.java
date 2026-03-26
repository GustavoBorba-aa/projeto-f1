package com.f1.management.service;

import com.f1.management.dto.CreateRacesDTO;
import com.f1.management.model.Races;
import com.f1.management.repository.RacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    private RacesRepository racesRepository;

    public Races saveRaces(CreateRacesDTO dto) {
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