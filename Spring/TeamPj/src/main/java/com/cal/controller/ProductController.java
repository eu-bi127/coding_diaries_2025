package com.cal.controller;

import com.cal.dto.ProductDto;
import com.cal.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService service;

    // 상품 조회 (수정 화면 진입 시 사용)
    @GetMapping("/get")
    public ProductDto getProduct(@RequestParam("id") int id) {
        ProductDto result = service.getProductById(id);
        log.info("조회한 상품: {}", result);
        return result;
    }

    // 상품 수정 (수정 후 저장할 때 사용)
    @PutMapping("/update")
    public void updateProduct(@RequestParam("id") int id, @RequestBody ProductDto dto) {
        service.updateProduct(id, dto);
        log.info("수정된 상품: {}", dto);
    }
}
