package com.cal.service;

import com.cal.dto.ProductDto;

public interface ProductService {
    
    // 상품 1개 조회 (수정 시 기존 데이터 가져오기)
    public ProductDto getProductById(int id);

    // 상품 수정
    public void updateProduct(int id, ProductDto product);
}
