package com.cal.controller;

import com.cal.dto.ProductDto;
import com.cal.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @RestController: @Controller + @ResponseBody 합친 애노테이션 (JSON 응답 용)
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // 1) 상품 조회 - 수정 화면에서 기존 데이터 불러올 때 사용
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable int id) {
        ProductDto product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    // 2) 상품 수정 - PUT 요청 처리
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody ProductDto productDto) {
        productService.updateProduct(id, productDto);
        return ResponseEntity
        		.ok()
        		.header("Content-Type", "text/plain; charset=UTF-8") //???로 깨져보여서 추가
        		.body("상품이 성공적으로 수정되었습니다.");
    }
}
