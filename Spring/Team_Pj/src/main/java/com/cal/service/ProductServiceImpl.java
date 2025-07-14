package com.cal.service;

import org.springframework.stereotype.Service;

import com.cal.dto.ProductDto;
import com.cal.mapper.ProductMapper;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

   
   private ProductMapper mapper;

   @Override
   public ProductDto getProductById(int id) {
       // 일단 DB 말고 하드코딩된 데이터로 연결 확인
       return mapper.selectProductById(id);
   }

    @Override
    public void updateProduct(int id, ProductDto dto) {
        dto.setId(id); // URL 경로의 id와 DTO id 동기화
        if (mapper.updateProduct(dto) == 0) {
            System.out.println("⚠️ 업데이트 실패: 상품 없음");
        }
    }
}
