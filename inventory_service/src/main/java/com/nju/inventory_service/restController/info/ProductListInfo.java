package com.nju.inventory_service.restController.info;

import java.util.List;

public class ProductListInfo {
    List<ProductInfo> productInfos;

    public void setProductInfos(List<ProductInfo> productInfos) {
        this.productInfos = productInfos;
    }

    public List<ProductInfo> getProductInfos() {

        return productInfos;
    }
}
