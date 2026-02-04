package com.f1.management.service;

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
        if (team.getName() == null || team.getName().isBlank()) {
            throw new RuntimeException("O nome do EQUIPE não pode ser branco");
        }
        if (team.getCountry() == null || team.getCountry().isBlank()) {
            throw new RuntimeException("O Páis de origem da equipe não pode estar vazio");
        }
        if (team.getCountry().length() < 2 || team.getCountry().length() > 20) {
            throw new RuntimeException("O país deve ter entre 2 e 20 caracteres.");
        }
        if (team.getEngine() == null || team.getEngine().isBlank()) {
            throw new RuntimeException("A fabricante do motor da equipe não pode está branco...");
        }
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
        //Busca a equipe pelo ID,
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada com o id: " + id));
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
        //Atualizamos os atributos do objeto que 'acabou de vir' do banco de dados
        team.setName(teamDetails.getName());
        team.setCountry(teamDetails.getCountry());
        team.setEngine(teamDetails.getEngine());
        return teamRepository.save(team);
    }


    // Lógica para deletar uma equipe.
    public void deleteTeam(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new RuntimeException("Não é possível deletar: Equipe não encontrada.");
        }
        teamRepository.deleteById(id);
    }
}