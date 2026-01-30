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

    // Rota para cadastrar um resultado (POST)
    @PostMapping
    public ResponseEntity<Results> create(@RequestBody CreateResultsDTO dto) {
        Results savedResults = resultsService.saveFromDto(dto);
        return ResponseEntity.ok(savedResults);
    }

}