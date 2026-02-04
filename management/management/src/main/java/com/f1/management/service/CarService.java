package com.f1.management.service;

import com.f1.management.dto.CreateCarDTO;
import com.f1.management.model.Car;
import com.f1.management.model.Team;
import com.f1.management.repository.CarRepository;
import com.f1.management.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Car saveCar(CreateCarDTO dto) {
        Team team = teamRepository.findById(dto.getTeamId())
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada!"));

        Car car = new Car();
        car.setModelCar(dto.getModelCar());
        car.setTeam(team);

        return carRepository.save(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car updateCar(Long id, CreateCarDTO dto) {
        Car car = carRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Esse Carro não existe"));


        Team team = teamRepository.findById(dto.getTeamId()) // Busca a equipe pelo ID que vem no DTO
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada!"));

        car.setModelCar(dto.getModelCar());
        car.setTeam(team);

        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Erro: esse ID não existe.");
        }
        carRepository.deleteById(id);
    }
}