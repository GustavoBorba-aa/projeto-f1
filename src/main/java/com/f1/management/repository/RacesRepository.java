package com.f1.management.repository;

import com.f1.management.model.Races;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacesRepository extends JpaRepository<Races, Long> {

}
