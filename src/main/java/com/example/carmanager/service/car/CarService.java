package com.example.carmanager.service.car;

import com.example.carmanager.model.product.Car;
import com.example.carmanager.repo.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CarService implements ICarService<Car>{
    @Autowired
    private ICarRepository iCarRepository;
    @Override
    public Page<Car> findAll(Pageable pageable) {
        return iCarRepository.findAll(pageable);
    }

    @Override
    public void save(Car car) {
        iCarRepository.save(car);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return iCarRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iCarRepository.deleteById(id);
    }
}