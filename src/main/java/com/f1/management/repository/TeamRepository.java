package com.f1.management.repository;

import com.f1.management.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    // Aqui herdamos todos os métodos do JpaRepository (save, findAll, delete, etc)
}