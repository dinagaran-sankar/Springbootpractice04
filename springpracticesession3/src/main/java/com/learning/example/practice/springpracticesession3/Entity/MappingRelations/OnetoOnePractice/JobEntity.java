package com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetoOnePractice;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "JobsCarrier")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "jobId",nullable = false)
//    private Integer id;
//    @Column(name = "JobCompanyName",nullable = false)
//    private String companyName;

    @Column(name = "JobJoinDate",nullable = false)
    private String joiningDate;
    @Column(name = "JobSalary",nullable = false)
    private String salaryStructure;
    @Column(name = "JobLeaves",nullable = false)
    private String employeeLeaves;
    @Column(name = "JobRegisterDate",nullable = false)
    private LocalDateTime dateTime;

    @EmbeddedId
    private JobsCompositePK jobsCompositePK;

    @OneToOne(mappedBy = "jobEntity",fetch = FetchType.EAGER)
    private UserJobsEntity userJobsEntity;
}
