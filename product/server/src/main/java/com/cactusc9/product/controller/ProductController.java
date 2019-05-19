package com.cactusc9.product.controller;

import com.cactusc9.product.VO.ProductInfoVO;
import com.cactusc9.product.VO.ProductVO;
import com.cactusc9.product.VO.ResultVO;
import com.cactusc9.product.common.DecreaseStockInput;
import com.cactusc9.product.common.ProductInfoOutput;
import com.cactusc9.product.model.ProductCategory;
import com.cactusc9.product.model.ProductInfo;
import com.cactusc9.product.service.CategoryService;
import com.cactusc9.product.service.ProductService;
import com.cactusc9.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. 查询所有在架商品
     * 2. 查询类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVO<List<ProductVO>> list() {
        List<ProductInfo> productInfoList = productService.findUp();
        List<Integer> productCategoryList = productInfoList.stream()
                .map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(productCategoryList);

        // 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryId())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.succeed(productVOList);
    }

    /**
     * 获取商品信息列表(给订单服务调用)
     * @param productIdList 商品idList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findByIdList(productIdList);
    }

    /**
     * 减库存(给订单服务调用)
     */
    @PostMapping("/decreaseStock")
    public String decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productService.decreaseStock(decreaseStockInputList);
        return "ok";
    }
}
