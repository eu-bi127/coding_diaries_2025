package com.cal.service;

import com.cal.dto.ProductDto;

public interface ProductService {
	 ProductDto getProductById(int id);
	 void updateProduct(int id, ProductDto dto);
}
