package com.learning.example.practice.springpracticesession3.Repository;

import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

    @Query("select p from ProductEntity p where p.productName=:name")
   Optional<ProductEntity> findByName(@Param("name") String name);
}
