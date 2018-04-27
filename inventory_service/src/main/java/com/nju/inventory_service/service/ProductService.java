package com.nju.inventory_service.service;

import com.nju.inventory_service.dao.ProductDAO;
import com.nju.inventory_service.model.PetProductEntity;
import com.nju.inventory_service.restController.info.ProductInfo;
import com.nju.inventory_service.restController.info.ProductListInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public int addProduct(ProductInfo productInfo) {
        Integer id = productInfo.getId();
        PetProductEntity petProductEntity = null;
        if (id == -1) {
            id = productDAO.findMaxId();
            if (id == null) id = 0;
            id++;
            petProductEntity = new PetProductEntity();
            petProductEntity.setId(id);
        } else {
            petProductEntity = productDAO.findOne(id);
        }
        petProductEntity.setCategoryId(productInfo.getCategory_id());
        petProductEntity.setPetName(productInfo.getPet_name());
        petProductEntity.setPetStore(productInfo.getPet_store());
        petProductEntity.setSinglePrice(productInfo.getPet_price());
        productDAO.save(petProductEntity);
        productDAO.flush();
        return 1;
    }

    public ProductListInfo getProducts(Integer cid) {
        List<PetProductEntity> productEntities = productDAO.findPetProductEntitiesByCategoryId(cid);
        ProductListInfo productListInfo = new ProductListInfo();
        List<ProductInfo> productInfos = new ArrayList<>();
        for (PetProductEntity productEntity : productEntities) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setId(productEntity.getId());
            productInfo.setCategory_id(cid);
            productInfo.setPet_name(productEntity.getPetName());
            productInfo.setPet_price(productEntity.getSinglePrice());
            productInfo.setPet_store(productEntity.getPetStore());
            productInfos.add(productInfo);
        }
        productListInfo.setProductInfos(productInfos);
        return productListInfo;
    }

    public ProductInfo getProduct(String petName) {
        PetProductEntity productEntity = productDAO.findPetProductEntityByPetName(petName);
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(productEntity.getId());
        productInfo.setCategory_id(productEntity.getCategoryId());
        productInfo.setPet_name(productEntity.getPetName());
        productInfo.setPet_price(productEntity.getSinglePrice());
        productInfo.setPet_store(productEntity.getPetStore());
        return productInfo;
    }
}
