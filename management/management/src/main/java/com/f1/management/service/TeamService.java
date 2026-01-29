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
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        // .findAll() retorna uma lista com todos os objetos encontrados (faz um SELECT *)
        return teamRepository.findAll();
    }

    /**
     * Lógica para atualizar uma equipe.
     * @param id ID da equipe que será modificada.
     * @param teamDetails Objeto com os novos dados vindos do Controller.
     */
    public Team updateTeam(Long id, Team teamDetails) {
        //Busca a equipe pelo ID,
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada com o id: " + id));
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