package com.f1.management.controller;

import com.f1.management.dto.CreateRaceDTO;
import com.f1.management.model.Races;
import com.f1.management.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/races")
public class RacesController {

    @Autowired
    private RaceService raceService;

    @PostMapping
    public ResponseEntity<Races> create(@RequestBody CreateRaceDTO dto) {
        Races savedRace = raceService.saveRaces(dto);
        return ResponseEntity.ok(savedRace);
    }

    @GetMapping
    public ResponseEntity<List<Races>> listAll(){
        return ResponseEntity.ok(raceService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Races> updateRaces(@PathVariable Long id, @RequestBody CreateRaceDTO dto){
        Races updateRaces = raceService.updateRaces(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        raceService.deleteRaces(id);
        return ResponseEntity.noContent().build();
    }
}