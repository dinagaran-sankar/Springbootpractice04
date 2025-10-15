package com.learning.example.practice.springpracticesession3.Controller;

import com.learning.example.practice.springpracticesession3.DTO.OnetoOnePractice.JobsDTO;
import com.learning.example.practice.springpracticesession3.DTO.OnetoOnePractice.JobsPKDTO;
import com.learning.example.practice.springpracticesession3.DTO.OnetoOnePractice.UserJobsDTO;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetoOnePractice.JobEntity;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetoOnePractice.JobsCompositePK;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetoOnePractice.UserJobsEntity;
import com.learning.example.practice.springpracticesession3.Repository.OnetoOnepractice.UserJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/userJobs")
public class UserJobController {

    private final UserJobRepository userJobRepository;

    @PostMapping(path = "/job-creation")
    public ResponseEntity<UserJobsDTO> createEmployeeJob(@RequestBody UserJobsDTO userJobsDTO)
    {
        System.out.println("user controller activation");
        System.out.println("job sonctoller: " + userJobsDTO);
        JobsDTO jobDTO = userJobsDTO.getJobDTO();

        //composite key
        JobsCompositePK jobsCompositePK = new JobsCompositePK();
        jobsCompositePK.setId(userJobsDTO.getJobDTO().getJobsPKDTO().getId());
        jobsCompositePK.setCompanyName(userJobsDTO.getJobDTO().getJobsPKDTO().getCompanyName());


        JobEntity jobEntity = new JobEntity();
       // jobEntity.setCompanyName(jobDTO.getCompanyName());
        jobEntity.setJoiningDate(jobDTO.getJoiningDate());
        jobEntity.setSalaryStructure(jobDTO.getSalaryStructure());
        jobEntity.setEmployeeLeaves(jobDTO.getEmployeeLeaves());
        jobEntity.setDateTime(LocalDateTime.now());
        jobEntity.setJobsCompositePK(jobsCompositePK);

        UserJobsEntity userJobsEntity = new UserJobsEntity();
        userJobsEntity.setName(userJobsDTO.getName());
        userJobsEntity.setNumberOfJobs(userJobsDTO.getNumberOfJobs());
        userJobsEntity.setMobileNumber(userJobsDTO.getMobileNumber());
        userJobsEntity.setJobEntity(jobEntity);

        UserJobsEntity save = userJobRepository.save(userJobsEntity);

        JobsPKDTO jobsPKDTO = new JobsPKDTO(save.getJobEntity().getJobsCompositePK().getId(),
                save.getJobEntity().getJobsCompositePK().getCompanyName());

        JobsDTO jobsDT1= new JobsDTO(save.getJobEntity().getJoiningDate()
        ,save.getJobEntity().getSalaryStructure(),save.getJobEntity().getEmployeeLeaves(),
                save.getJobEntity().getDateTime(),jobsPKDTO);

        UserJobsDTO userJobsDTO1 = new UserJobsDTO(save.getName(),save.getNumberOfJobs(),save.getMobileNumber(),jobsDT1);

        return  ResponseEntity.ok().body(userJobsDTO1);
    }

    @GetMapping("/fetchJobDetails/{id}")
    public ResponseEntity<UserJobsDTO> fetchJobDetails(@PathVariable Integer id){

//        JobsCompositePK byJobsCompositePKId = userJobRepository.findByJobEntity_JobsCompositePK_JobsId(id).get();
//        byJobsCompositePKId.getCompanyName();
//        byJobsCompositePKId.getId();

       // UserJobsEntity userJobsEntity = userJobRepository.findById(byJobsCompositePKId).get();
        UserJobsEntity userJobsEntity = userJobRepository.findById(id).get();

        JobEntity jobEntity = userJobsEntity.getJobEntity();

        JobsPKDTO jobsPKDTO = new JobsPKDTO(jobEntity.getJobsCompositePK().getId()
                , jobEntity.getJobsCompositePK().getCompanyName());

        JobsDTO jobsDTO = new JobsDTO(jobEntity.getJoiningDate(),
                jobEntity.getSalaryStructure(),
                jobEntity.getEmployeeLeaves(),jobEntity.getDateTime(),jobsPKDTO);

        UserJobsDTO userJobsDTO = new UserJobsDTO(userJobsEntity.getName(),
                userJobsEntity.getNumberOfJobs(),userJobsEntity.getMobileNumber(),jobsDTO);

        return ResponseEntity.ok().body(userJobsDTO);

    }
}

