package com.f1.management.controller;

import com.f1.management.dto.CreateTeamDTO;
import com.f1.management.model.Team;
import com.f1.management.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<Team> create(@RequestBody CreateTeamDTO dto) {
        Team newTeam = new Team(null, dto.getName(), dto.getCountry(), dto.getEngine(), dto.getFoundationYear(),
                dto.getSedeDaEquipe(), dto.getChefeDeEquipe());
        Team savedTeam = teamService.saveTeam(newTeam);
        return ResponseEntity.ok(savedTeam);
    }

    @GetMapping
    public ResponseEntity<List<Team>> listAll() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Team> update(@PathVariable Long id, @RequestBody CreateTeamDTO dto) {
        Team teamDetails = new Team(null,dto.getName(), dto.getCountry(), dto.getEngine(), dto.getFoundationYear(),
                dto.getSedeDaEquipe(), dto.getChefeDeEquipe());
        Team updatedTeam = teamService.updateTeam(id, teamDetails);
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}