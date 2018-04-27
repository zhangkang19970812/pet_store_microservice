package com.nju.inventory_service.restController.info;

import java.util.List;

public class CategoryListInfo {
    List<CategoryInfo> categoryInfos;

    public void setCategoryInfos(List<CategoryInfo> categoryInfos) {
        this.categoryInfos = categoryInfos;
    }

    public List<CategoryInfo> getCategoryInfos() {

        return categoryInfos;
    }
}
