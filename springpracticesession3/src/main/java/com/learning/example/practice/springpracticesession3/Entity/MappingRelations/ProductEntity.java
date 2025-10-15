package com.learning.example.practice.springpracticesession3.Entity.MappingRelations;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="orderProduct")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String productName;
    private String productCost;
}
