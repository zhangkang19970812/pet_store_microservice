package com.nju.inventory_service.service;

import com.nju.inventory_service.dao.CategoryDAO;
import com.nju.inventory_service.model.PetCategoryEntity;
import com.nju.inventory_service.restController.info.CategoryInfo;
import com.nju.inventory_service.restController.info.CategoryListInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public int addCategory(CategoryInfo categoryInfo){
        Integer id = categoryInfo.getId();
        PetCategoryEntity petCategoryEntity = null;
        if (id == -1){
            id = categoryDAO.findMaxId();
            if (id == null) id = 0;
            id++;
            petCategoryEntity = new PetCategoryEntity();
            petCategoryEntity.setId(id);
        } else {
            petCategoryEntity = categoryDAO.findOne(id);
        }
        petCategoryEntity.setCategory(categoryInfo.getName());
        petCategoryEntity.setDescription(categoryInfo.getDept());
        categoryDAO.save(petCategoryEntity);
        categoryDAO.flush();
        return 1;
    }

    public CategoryListInfo getList(){
        CategoryListInfo categoryListInfo = new CategoryListInfo();
        List<CategoryInfo> categoryInfos = new ArrayList<>();
        List<PetCategoryEntity> petCategoryEntities = categoryDAO.findAll();
        for (PetCategoryEntity petCategoryEntity: petCategoryEntities){
            CategoryInfo categoryInfo = new CategoryInfo();
            categoryInfo.setId(petCategoryEntity.getId());
            categoryInfo.setName(petCategoryEntity.getCategory());
            categoryInfo.setDept(petCategoryEntity.getDescription());
            categoryInfos.add(categoryInfo);
        }
        categoryListInfo.setCategoryInfos(categoryInfos);
        return categoryListInfo;
    }

}
