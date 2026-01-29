package com.f1.management.service;


import com.f1.management.model.Car;
import com.f1.management.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car updateCar(Long id, Car carDetails) {
        Car car = carRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Esse Carro não existe"));
        car.setModelCar(carDetails.getModelCar());
        car.setTeam(carDetails.getTeam());

        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Erro: esse ID não existe.");
        }
        carRepository.deleteById(id);
    }
}
