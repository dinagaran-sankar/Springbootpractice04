package com.learning.example.practice.springpracticesession3.Repository.onetomany;

import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.onetomany.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
}
