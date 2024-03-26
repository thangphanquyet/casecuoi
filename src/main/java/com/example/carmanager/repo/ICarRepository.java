package com.example.carmanager.repo;

import com.example.carmanager.model.product.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ICarRepository extends CrudRepository<Car,Long> {
    Page<Car> findAll(Pageable pageable);
}