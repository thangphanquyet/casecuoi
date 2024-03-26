package com.example.carmanager.repo;

import com.example.carmanager.model.product.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ITypeRepository extends CrudRepository<Type,Long> {
    Page<Type> findAll(Pageable pageable);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "CALL delete_type(:id);")
    void deleteTypeById(@Param("id") Long id);
}