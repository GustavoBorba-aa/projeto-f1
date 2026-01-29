package com.f1.management.controller;

import com.f1.management.dto.CreateDriverDTO;
import com.f1.management.model.Driver;
import com.f1.management.service.DriverService;
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
    public ResponseEntity<Driver> create(@RequestBody CreateDriverDTO dto){
        Driver newDriver = new Driver(dto.getName(), dto.getNationality(), dto.getNumber(), dto.getTeam());
        Driver saveDriver = driverService.saveDriver(newDriver);
        return ResponseEntity.ok(saveDriver);
    }
    @GetMapping
    public ResponseEntity<List<Driver>> listAll(){
        return ResponseEntity.ok(driverService.findAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Driver> update(@PathVariable Long id, @RequestBody CreateDriverDTO dto){
        Driver driverDetails = new Driver(dto.getName(), dto.getNationality(), dto.getNumber(),dto.getTeam());
        Driver updatedDriver = driverService.updateDriver(id, driverDetails);
        return ResponseEntity.ok(updatedDriver);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}
