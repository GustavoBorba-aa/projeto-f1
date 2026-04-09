package com.f1.management.service;

import com.f1.management.model.Team;
import com.f1.management.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeamService {


    @Autowired
    private TeamRepository teamRepository;

    public Team saveTeam(Team team) {

        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }


    public Team updateTeam(Long id, Team teamDetails) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada com o id: " + id));

        team.setName(teamDetails.getName());
        team.setCountry(teamDetails.getCountry());
        team.setEngine(teamDetails.getEngine());
        team.setFoundationYear(teamDetails.getFoundationYear());
        team.setSedeDaEquipe(teamDetails.getSedeDaEquipe());
        team.setChefeDeEquipe(teamDetails.getChefeDeEquipe());
        return teamRepository.save(team);
    }


    public void deleteTeam(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new RuntimeException("Não é possível deletar: Equipe não encontrada.");
        }
        teamRepository.deleteById(id);
    }
}