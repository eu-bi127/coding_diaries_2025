package com.cal.mapper;
import com.cal.dto.ProductDto;

public interface ProductMapper {

   public ProductDto selectProductById(int id);         // 상품 1개 조회

   public int updateProduct(ProductDto product);         // 상품 수정
}