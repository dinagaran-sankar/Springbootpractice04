package com.learning.example.practice.springpracticesession3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderProductDTO {

    private String productName;
    private String productCost;
}
