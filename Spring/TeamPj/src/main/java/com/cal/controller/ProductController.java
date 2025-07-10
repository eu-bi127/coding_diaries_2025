package com.cal.controller;

import com.cal.dto.ProductDto;
import com.cal.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService service;

    @GetMapping("/get")
    public ResponseEntity<?> getProduct(@RequestParam("id") int id) {
        ProductDto result = service.getProductById(id);

        if (result == null) {
            // id가 없으면 404 응답 (NOT FOUND)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("해당 ID의 상품을 찾을 수 없습니다: " + id);
        }

        return ResponseEntity.ok(result); // 정상 응답
    }
    // 상품 수정 (수정 후 저장할 때 사용)
    @PutMapping("/update")
    public void updateProduct( @RequestParam("id") int id, @RequestBody ProductDto dto) {
        service.updateProduct(id, dto);
        log.info("수정된 상품: {}", dto);
    }
}
