package com.cactusc9.product.service.impl;

import com.cactusc9.product.dto.ProductDTO;
import com.cactusc9.product.enums.ExceptionEnum;
import com.cactusc9.product.enums.ProductStatusEnum;
import com.cactusc9.product.exception.ProductException;
import com.cactusc9.product.model.ProductInfo;
import com.cactusc9.product.repository.ProductInfoRepository;
import com.cactusc9.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUp() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findByIdList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<ProductDTO> productDTOList) {
        for (ProductDTO productDTO : productDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(productDTO.getProductId());
            // 检查商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ExceptionEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            // 检查商品库存
            int result = productInfo.getProductStock() - productDTO.getProductQuantity();
            if (result < 0){
                throw  new ProductException(ExceptionEnum.PRODUCT_STOCK_ERR);
            }
            // 减库存
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
