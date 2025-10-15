package com.learning.example.practice.springpracticesession3.Repository.onetomanypractice;

import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetomanyPractice.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentChildRelationshipRepository extends JpaRepository<ParentEntity,Integer> {


}
