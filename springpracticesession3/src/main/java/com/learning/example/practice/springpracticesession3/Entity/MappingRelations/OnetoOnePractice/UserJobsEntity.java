package com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetoOnePractice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserCarrier")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserJobsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId",nullable = false)
    private Integer id;
    @Column(name = "UserName",nullable = false)
    private String name;
    @Column(name = "No.Of.Jobs",nullable = false)
    private String numberOfJobs;
    @Column(name = "UserContactNumber",nullable = false)
    private String mobileNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "JobsId", referencedColumnName = "JobsId"),
            @JoinColumn(name = "JobCompanyName", referencedColumnName = "JobCompanyName")
    })
    private JobEntity jobEntity;
}
