package com.f1.management.controller;

import com.f1.management.dto.CreateDriverDTO;
import com.f1.management.model.Driver;
import com.f1.management.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<Driver> create(@RequestBody @Valid CreateDriverDTO dto) { //Valid = validar o objeto dto
        Driver savedDriver = driverService.saveFromDto(dto);
        return ResponseEntity.ok(savedDriver);
    }

    @GetMapping
    public ResponseEntity<List<Driver>> listAll() {
        return ResponseEntity.ok(driverService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> update(@PathVariable Long id, @RequestBody CreateDriverDTO dto) {
        Driver updatedDriver = driverService.updateFromDto(id, dto);
        return ResponseEntity.ok(updatedDriver);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}