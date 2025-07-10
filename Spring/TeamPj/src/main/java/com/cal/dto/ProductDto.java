package com.cal.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
   private int id;
   private String name;
   private int price;
   private String category;
   private String imageUrl;
}