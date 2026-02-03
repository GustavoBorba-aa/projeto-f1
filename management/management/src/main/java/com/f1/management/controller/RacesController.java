package com.f1.management.controller;

import com.f1.management.dto.CreateRacesDTO;
import com.f1.management.model.Races;
import com.f1.management.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Habilita a classe como API REST (retorno automático em JSON).
@RequestMapping("/races") // Define a rota base da URL (ex: localhost:8080/races).
public class RacesController {

    @Autowired // Injeção automática: o Spring gerencia a instância do Service.
    private RaceService raceService;

    @PostMapping // Mapeia requisições POST para criação de dados.
    public ResponseEntity<Races> create(@RequestBody CreateRacesDTO dto) {
        // @RequestBody: Converte o JSON do corpo da requisição no objeto 'dto'.
        Races savedRace = raceService.saveRaces(dto);
        return ResponseEntity.ok(savedRace); // Retorna Status 200 e a corrida salva.
    }

    @GetMapping // Mapeia requisições GET para busca/listagem.
    public ResponseEntity<List<Races>> listAll(){
        // Retorna uma lista de todas as corridas do banco.
        return ResponseEntity.ok(raceService.findAll());
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para atualização via ID na URL.
    public ResponseEntity<Races> updateRaces(@PathVariable Long id, @RequestBody CreateRacesDTO dto){
        // @PathVariable: Captura o ID da URL; @RequestBody: Captura os novos dados.
        Races updateRaces = raceService.updateRaces(id, dto);
        return ResponseEntity.noContent().build(); // Retorna Status 204 (Sucesso, sem corpo).
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para remoção via ID.
    public ResponseEntity<Void> delete(@PathVariable Long id){
        raceService.deleteRaces(id); // Chama o service para excluir o registro.
        return ResponseEntity.noContent().build(); // Retorna Status 204 após deletar.
    }
}