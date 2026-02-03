package com.f1.management.controller;

import com.f1.management.dto.CreateResultsDTO;
import com.f1.management.model.Results;
import com.f1.management.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results") // Segue o padrão /teams
public class ResultsController {

    @Autowired
    private ResultsService resultsService;

    @PostMapping
    public ResponseEntity<Results> create(@RequestBody CreateResultsDTO dto) {
        Results savedResults = resultsService.saveFromDto(dto);
        return ResponseEntity.ok(savedResults);
    }

    @GetMapping
    public ResponseEntity<List<Results>> listAll() {
        return ResponseEntity.ok(resultsService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Results> update(@PathVariable Long id, @RequestBody CreateResultsDTO dto) {
        Results updateResults = resultsService.updateResults(id, dto);
        return ResponseEntity.noContent().build();
    }
   @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        resultsService.deleteResults(id);
        return ResponseEntity.noContent().build();
   }
}