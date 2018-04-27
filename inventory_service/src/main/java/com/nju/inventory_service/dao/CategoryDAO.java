package com.nju.inventory_service.dao;

import com.nju.inventory_service.model.PetCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryDAO extends JpaRepository<PetCategoryEntity,Integer> {
    @Query("select max(entity.id) from PetCategoryEntity entity")
    Integer findMaxId();
}
