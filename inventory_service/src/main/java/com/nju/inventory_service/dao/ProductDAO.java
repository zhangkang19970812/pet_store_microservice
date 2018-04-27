package com.nju.inventory_service.dao;

import com.nju.inventory_service.model.PetProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<PetProductEntity, Integer> {
    @Query("select max(entity.id) from PetProductEntity entity")
    Integer findMaxId();

    List<PetProductEntity> findPetProductEntitiesByCategoryId(Integer CategoryId);

    PetProductEntity findPetProductEntityByPetName(String petName);
}
