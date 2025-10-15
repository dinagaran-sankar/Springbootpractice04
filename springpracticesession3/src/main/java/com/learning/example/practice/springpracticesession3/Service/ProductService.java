package com.learning.example.practice.springpracticesession3.Service;

import com.learning.example.practice.springpracticesession3.DTO.OrderProductDTO;
import org.springframework.core.annotation.Order;

public interface ProductService {


    OrderProductDTO createCustomerOrderProduct(OrderProductDTO orderProductDTO);
    OrderProductDTO fetchCustomerOrderDetails(String name);

}
