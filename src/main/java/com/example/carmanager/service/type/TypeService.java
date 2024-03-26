package com.example.carmanager.service.type;

import com.example.carmanager.model.product.Type;
import com.example.carmanager.repo.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TypeService implements ITypeService<Type>{
    @Autowired
    private ITypeRepository iTypeRepository;
    @Override
    public Page<Type> findAll(Pageable pageable) {
        return iTypeRepository.findAll(pageable);
    }

    @Override
    public void save(Type type) {
        iTypeRepository.save(type);
    }

    @Override
    public Optional<Type> findById(Long id) {
        return iTypeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iTypeRepository.deleteTypeById(id);
    }
}