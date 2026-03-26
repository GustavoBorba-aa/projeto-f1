package com.f1.management.repository;

import com.f1.management.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//INTERFACE QUE HERDA TODOS OS METODOS DO CRUD: SAVE, FINDALL, DELETE E UPDATE.
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>  {
}
