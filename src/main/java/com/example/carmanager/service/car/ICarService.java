package com.example.carmanager.service.car;

import com.example.carmanager.model.product.Car;
import com.example.carmanager.service.IGenerateService;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarService<C> extends IGenerateService<Car> {
}