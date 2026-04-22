package com.f1.management.controller;


import com.f1.management.dto.CreateCarDTO;
import com.f1.management.model.Car;
import com.f1.management.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody CreateCarDTO dto){
        Car savedCar = carService.saveCar(dto);
        return ResponseEntity.ok(savedCar);
    }

    @GetMapping
    public ResponseEntity<List<Car>> listAll(){
        return ResponseEntity.ok(carService.findAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody CreateCarDTO dto){
        Car updateCar = carService.updateCar(id, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}