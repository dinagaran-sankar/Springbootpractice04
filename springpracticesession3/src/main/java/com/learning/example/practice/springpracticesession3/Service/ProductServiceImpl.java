package com.learning.example.practice.springpracticesession3.Service;

import com.learning.example.practice.springpracticesession3.DTO.OrderProductDTO;
import com.learning.example.practice.springpracticesession3.DTO.ProductDTO;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.ProductEntity;
import com.learning.example.practice.springpracticesession3.Repository.ProductRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private EntityManager entityManager;

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Override
    public OrderProductDTO createCustomerOrderProduct(OrderProductDTO orderProductDTO) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(orderProductDTO.getProductName());
        productEntity.setProductCost(orderProductDTO.getProductCost());

        productRepository.save(productEntity);

        OrderProductDTO productDTO = new
                OrderProductDTO(productEntity.getProductName(),productEntity.getProductCost());

        return productDTO;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = true)
    @Override
    public OrderProductDTO fetchCustomerOrderDetails(String name) {

        ProductEntity byName = productRepository.findByName(name).get();

        OrderProductDTO orderProductDTO =
                new OrderProductDTO(byName.getProductName(),byName.getProductCost());

        return orderProductDTO;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void updateProduct(String name,String cost) throws InterruptedException {
        ProductEntity productEntity = productRepository.findByName(name).get();
        productEntity.setProductName("Bike Cover");
        productEntity.setProductCost("3800");

        productRepository.save(productEntity);
        entityManager.flush();

        System.out.println("Transaction A get chance to update " + productEntity.getProductCost() + " name " + productEntity.getProductName());
        Thread.sleep(8000);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        System.out.println("Transaction A Rollback the changes");
        //System.out.println("Transaction A commit the changes");

    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public int fetchproduct(String name)
    {
        ProductEntity productEntity = productRepository.findByName(name).get();
        System.out.println("Transaction B  read product details : " + productEntity.getProductName()
                + " cost " + productEntity.getProductCost());

        return productEntity.getOrderId();
    }
//    @Transactional(isolation = Isolation.REPEATABLE_READ)
//    public int fetchproduct(String name)
//    {
//        ProductEntity productEntity = productRepository.findByName(name).get();
//        System.out.println("Transaction B first read product details : " + productEntity.getProductName()
//                + " cost " + productEntity.getProductCost());
//
//        ProductEntity productEntity2 = productRepository.findByName(name).get();
//        System.out.println("Transaction B second read product details : " + productEntity.getProductName()
//                + " cost " + productEntity.getProductCost());
//
//        return productEntity.getOrderId();
//    }

    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.READ_COMMITTED,readOnly = false)
    @Override
    public void createOrderProduct(String  name,String cost) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setOrderId(1);
        productEntity.setProductName(name);
        productEntity.setProductCost(cost);

        productRepository.save(productEntity);

        System.out.println("createProduct(): New product created and committed (REQUIRES_NEW TX)");
    }

    @Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.READ_COMMITTED,readOnly = false)
    @Override
    public void updateOrderProduct(String  name,String cost) {

        ProductEntity byName = productRepository.findByName(name).get();
        byName.setProductCost(cost);

        productRepository.save(byName);

        System.out.println("✅ updateProduct(): Product updated in existing TX");
    }


}
