package com.example.carmanager.repo;

import com.example.carmanager.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<User,Long> {
    Page<User> findAll(Pageable pageable);
    User findByUserName(String name);
}