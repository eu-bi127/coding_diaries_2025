package com.cal.mapper;

import com.cal.dto.ProductDto;

public interface ProductMapper {
    
	//테스트 주석
    // 상품 1개 조회 (수정할 상품 불러오기용)
    public ProductDto selectProductById(int id);

    // 상품 수정
    public int updateProduct(ProductDto product);
}
