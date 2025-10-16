package com.learning.example.practice.springpracticesession3.Service.Propagation;

import com.learning.example.practice.springpracticesession3.DTO.OrderProductDTO;
import com.learning.example.practice.springpracticesession3.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadCommenetdusingpropagation {

    @Autowired
    private  ProductService productService;

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED,readOnly = false)
    public void placeOrder(boolean fail)
    {
        System.out.println("🟢 placeOrder(): Starting main transaction");

        productService.createOrderProduct("SareeS","14500");
        System.out.println("parent create transaction success after completed the child");
        productService.updateOrderProduct("SareeS","13300");
        System.out.println("parent update transaction success after completed the child");
        if (fail) {
            System.out.println("💥 placeOrder(): Simulating failure...");
            throw new RuntimeException("Order failed!");
        }
        System.out.println("🟢 placeOrder(): Main transaction completed");
    }
}
