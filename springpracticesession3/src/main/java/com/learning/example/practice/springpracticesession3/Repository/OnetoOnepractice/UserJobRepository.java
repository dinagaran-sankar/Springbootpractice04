package com.learning.example.practice.springpracticesession3.Repository.OnetoOnepractice;

import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetoOnePractice.JobEntity;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetoOnePractice.JobsCompositePK;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetoOnePractice.UserJobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJobRepository extends JpaRepository<UserJobsEntity, Integer> {

        //Optional<JobsCompositePK> findByJobEntity_JobsCompositePK_JobsId(Integer id);
}
