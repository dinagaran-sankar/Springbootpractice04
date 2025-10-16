package com.learning.example.practice.springpracticesession3.Service.Isolation;

import com.learning.example.practice.springpracticesession3.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReadUnCommentedDemo {

    private final ProductService productService;

    public void testTransactionReadUnCommited(String name,String cost) throws InterruptedException {

        Thread A = new Thread(()->{
            try{
               // Thread.sleep(2000);
                productService.updateProduct(name,cost);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread B = new Thread(()->{
            try{
                Thread.sleep(2000);
                int fetchProduct = productService.fetchproduct(name);
                System.out.println("Stock read by Transaction B: " + fetchProduct);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        A.start();
        B.start();

        A.join();
        B.join();

    }

}
