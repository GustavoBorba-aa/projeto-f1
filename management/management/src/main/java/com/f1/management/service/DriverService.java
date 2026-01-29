package com.f1.management.service;

import com.f1.management.model.Driver;
import com.f1.management.repository.DriverRepository;
import com.f1.management.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class DriverService {

    @Autowired // Injeção do repositório de Pilotos (Essencial para salvar Driver)
    private DriverRepository driverRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }
    public Driver updateDriver(Long id, Driver driverDtails) {
        Driver driver = driverRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Esse piloto não existe: " + id));
        driver.setName(driverDtails.getName());
        driver.setNationality(driverDtails.getNationality());
        driver.setNumber(driverDtails.getNumber());
        driver.setTeam(driverDtails.getTeam());

        return driverRepository.save(driver);
    }

    public void deleteDriver(Long id) {
        if (!driverRepository.existsById(id)) {
            throw new RuntimeException("erro: esse Id não existe.");
        }
        driverRepository.deleteById(id);
    }
}
