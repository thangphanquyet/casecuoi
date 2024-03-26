package com.example.carmanager.repo;

import com.example.carmanager.model.user.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends CrudRepository<Role, Long> {
}