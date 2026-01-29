package com.f1.management.service;


import com.f1.management.model.Races;
import com.f1.management.repository.RacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    private RacesRepository racesRepository;

    public Races saveRaces(Races races) {
        return racesRepository.save(races);
    }

    public List<Races> findAll() {
        return racesRepository.findAll();
    }

    public Races updateRaces(Long id, Races racesDetails) {
        Races races = racesRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Erro: essa corrida não existe: "));
        races.setRaceDate(racesDetails.getRaceDate());
        races.setGrandPrixName(racesDetails.getGrandPrixName());
        races.setNameCircuit(racesDetails.getNameCircuit());
        return racesRepository.save(races);
    }

    public void deleteRaces(Long id) {
        if (!racesRepository.existsById(id)) {
            throw new RuntimeException("Erro: esse ID não existe.");
        }
        racesRepository.deleteById(id);
    }
}
