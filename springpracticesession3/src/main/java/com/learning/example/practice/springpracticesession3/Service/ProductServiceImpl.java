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




}
