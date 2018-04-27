package com.nju.inventory_service.restController;

import com.nju.inventory_service.restController.info.ProductInfo;
import com.nju.inventory_service.restController.info.ProductListInfo;
import com.nju.inventory_service.restController.vo.ResultVO;
import com.nju.inventory_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //add/list/detail/update

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultVO add(@RequestBody ProductInfo productInfo){
        if (productService.addProduct(productInfo) == 1){
            return new ResultVO("add a pet", 1);
        }
        return new ResultVO("fail", 0);
    }

    @RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
    public ProductListInfo getList(@PathVariable Integer cid){
        return productService.getProducts(cid);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultVO update(@RequestBody ProductInfo productInfo){
        if (productService.addProduct(productInfo) == 1){
            return new ResultVO("update a pet", 1);
        }
        return new ResultVO("fail", 0);
    }

    @RequestMapping(value = "/detail/{petName}", method = RequestMethod.GET)
    public ProductInfo get(@PathVariable String petName){
        return productService.getProduct(petName);
    }
}
