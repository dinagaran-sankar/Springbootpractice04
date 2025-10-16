package com.learning.example.practice.springpracticesession3.Service;

import com.learning.example.practice.springpracticesession3.DTO.OrderProductDTO;
import org.springframework.core.annotation.Order;

public interface ProductService {


    OrderProductDTO createCustomerOrderProduct(OrderProductDTO orderProductDTO);
    OrderProductDTO fetchCustomerOrderDetails(String name);
    void updateProduct(String name,String cost) throws InterruptedException;
    int fetchproduct(String name);

    void createOrderProduct(String  name,String cost);

    void updateOrderProduct(String  name,String cost);

}
