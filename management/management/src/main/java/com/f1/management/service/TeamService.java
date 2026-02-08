package com.f1.management.service;

import com.f1.management.dto.CreateTeamDTO;
import com.f1.management.model.Team;
import com.f1.management.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A anotação @Service indica que esta classe é um "Bean" de serviço do Spring.
 * Aqui é onde a lógica de negócio deve morar, servindo de ponte entre o Controller e o Repository.
 */
@Service
public class TeamService {

    /**
     * @Autowired faz a "Injeção de Dependência".
     * O Spring cria automaticamente uma instância de TeamRepository e a entrega aqui.
     */
    @Autowired
    private TeamRepository teamRepository;

    public Team saveTeam(Team team) {
        validacoesServiceTeam(team);
        validarFundationYear(team.getFoundationYear());
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        // .findAll() retorna uma lista com todos os objetos encontrados (faz um SELECT *)
        return teamRepository.findAll();
    }

    /**
     * Lógica para atualizar uma equipe.
     *
     * @param id          ID da equipe que será modificada.
     * @param teamDetails Objeto com os novos dados vindos do Controller.
     */
    public Team updateTeam(Long id, Team teamDetails) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada com o id: " + id));
        validacoesServiceTeam(teamDetails);
        validarFundationYear(teamDetails.getFoundationYear());

        team.setName(teamDetails.getName());
        team.setCountry(teamDetails.getCountry());
        team.setEngine(teamDetails.getEngine());
        team.setFoundationYear(teamDetails.getFoundationYear());
        team.setSedeDaEquipe(teamDetails.getSedeDaEquipe());
        team.setChefeDeEquipe(teamDetails.getChefeDeEquipe());
        return teamRepository.save(team);
    }


    // Lógica para deletar uma equipe.
    public void deleteTeam(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new RuntimeException("Não é possível deletar: Equipe não encontrada.");
        }
        teamRepository.deleteById(id);
    }
    public void validacoesServiceTeam(Team teamDetails){
        if (teamDetails.getName() == null || teamDetails.getName().isBlank()) {
            throw new RuntimeException("O nome da EQUIPE não pode ser branco");
        }
        if (teamDetails.getCountry() == null || teamDetails.getCountry().isBlank()) {
            throw new RuntimeException("O Páis de origem da equipe não pode estar vazio");
        }
        if (teamDetails.getCountry().length() < 2 || teamDetails.getCountry().length() > 20) {
            throw new RuntimeException("O país deve ter entre 2 e 20 caracteres.");
        }
        if (teamDetails.getEngine() == null || teamDetails.getEngine().isBlank()) {
            throw new RuntimeException("A fabricante do motor da equipe não pode está branco...");
        }
        if (teamDetails.getSedeDaEquipe() == null || teamDetails.getSedeDaEquipe().isBlank()){
            throw new RuntimeException("A sede da EQUIPE(TEAM) não pode estar vazio.");
        }
        if (teamDetails.getChefeDeEquipe() == null || teamDetails.getChefeDeEquipe().isBlank()){
            throw new RuntimeException("O chefe equipe(TEAM) não pode estar vazio.");
        }
    }

    public void validarFundationYear(Integer year){
        if (year == null) {
            throw new RuntimeException("O ano de fundação é obrigatório.");
        }
        if (year < 1950 || year > 2026) {
            throw new RuntimeException("Ano inválido! A F1 começou em 1950 e não prevemos o futuro além de 2026.");
        }
    }
}