package com.learning.example.practice.springpracticesession3.Controller;

import com.learning.example.practice.springpracticesession3.DTO.OrderProductDTO;
import com.learning.example.practice.springpracticesession3.Repository.ProductRepository;
import com.learning.example.practice.springpracticesession3.Service.Isolation.ReadUnCommentedDemo;
import com.learning.example.practice.springpracticesession3.Service.ProductService;
import com.learning.example.practice.springpracticesession3.Service.Propagation.ReadCommenetdusingpropagation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-product")
@RequiredArgsConstructor
public class OrderProductController {

    private final ProductService productService;

    private final ReadUnCommentedDemo readUnCommentedDemo;

    private final ReadCommenetdusingpropagation readCommenetdusingpropagation;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderProductDTO> createCustomerOrderProduct(@RequestBody OrderProductDTO orderProductDTO)
    {
        OrderProductDTO customerOrderProduct = productService.createCustomerOrderProduct(orderProductDTO);

        return ResponseEntity.ok().body(customerOrderProduct);
    }

    @GetMapping("/fetchCustomerOrderDetails")
    public ResponseEntity<OrderProductDTO> fetchCustomerOrderDetails(@RequestParam("name") String name)
    {
        OrderProductDTO orderProductDTO = productService.fetchCustomerOrderDetails(name);
        return ResponseEntity.ok().body(orderProductDTO);
    }

    @GetMapping("/test-isolation")
    public ResponseEntity<String> testIsolation(@RequestBody OrderProductDTO orderProductDTO) throws InterruptedException {

        readUnCommentedDemo.testTransactionReadUnCommited(orderProductDTO.getProductName(),
                orderProductDTO.getProductCost());
        return ResponseEntity.ok().body("Succeess");
    }

    @GetMapping("/placeOrder")
    public ResponseEntity<String> testPropagation(@RequestParam boolean fail)
    {
        readCommenetdusingpropagation.placeOrder(fail);
        return ResponseEntity.ok().body("success");
    }
}
