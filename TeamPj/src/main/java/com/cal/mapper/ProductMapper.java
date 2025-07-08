package com.cal.mapper;
import com.cal.dto.ProductDto;

public interface ProductMapper {

    ProductDto selectProductById(int id);         // 상품 1개 조회

    int updateProduct(ProductDto product);         // 상품 수정
}