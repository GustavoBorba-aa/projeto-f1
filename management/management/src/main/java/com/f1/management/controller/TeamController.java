package com.f1.management.controller;

import com.f1.management.dto.CreateTeamDTO;
import com.f1.management.model.Team;
import com.f1.management.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams") // Todas as rotas aqui começam com /teams
public class TeamController {

    @Autowired
    private TeamService teamService;

    // Rota para cadastrar uma equipe (POST http://localhost:8080/teams)
    @PostMapping
    public ResponseEntity<Team> create(@RequestBody CreateTeamDTO dto) {
        Team newTeam = new Team(dto.getName(), dto.getCountry(), dto.getEngine(), dto.getFoundationYear(),
                dto.getSedeDaEquipe(), dto.getChefeDeEquipe());
        Team savedTeam = teamService.saveTeam(newTeam);
        return ResponseEntity.ok(savedTeam);
    }

    // Rota para listar equipes (GET http://localhost:8080/teams)
    @GetMapping
    public ResponseEntity<List<Team>> listAll() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }
    // --- UPDATE ---
    @PutMapping("/{id}")
    public ResponseEntity<Team> update(@PathVariable Long id, @RequestBody CreateTeamDTO dto) {
        Team teamDetails = new Team(dto.getName(), dto.getCountry(), dto.getEngine(), dto.getFoundationYear(),
                dto.getSedeDaEquipe(), dto.getChefeDeEquipe());
        Team updatedTeam = teamService.updateTeam(id, teamDetails);
        return ResponseEntity.ok(updatedTeam);
    }

    // --- DELETE ---
    @DeleteMapping("/{id}") // A URL será /teams/1
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}