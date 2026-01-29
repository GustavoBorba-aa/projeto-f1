package com.f1.management.service;


import com.f1.management.model.Results;
import com.f1.management.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsService {

    @Autowired
    private ResultsRepository resultsRepository;

    public Results saveResults(Results results) {
        return resultsRepository.save(results);
    }
    public List<Results> findAll(){
        return resultsRepository.findAll();
    }
    public Results updateResults(Long id, Results resultsDetails){
        Results results = resultsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Erro: esse resultado não existe: "));
        results.setDriver(resultsDetails.getDriver());
        results.setPosition(resultsDetails.getPosition());
        results.setPointsEarned(resultsDetails.getPointsEarned());
        return resultsRepository.save(results);
    }
    public void deleteResults(Long id){
        if (!resultsRepository.existsById(id)){
            throw new RuntimeException("Erro: esse ID não existe: ");
        }
        resultsRepository.deleteById(id);
    }
}
