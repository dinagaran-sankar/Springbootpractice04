package com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetomanyPractice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "parentRelation")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParentEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "parentId",nullable = false)
//    private Integer id;
//    @Column(name = "parentName",nullable = false)
//    private String name;

    @EmbeddedId
    private ParentPKEntity parentPKEntity;

    @Column(name = "parentContactNo",nullable = false)
    private String mobileNumber;
    @Column(name = "parentAddress",nullable = false)
    private String address;

    @OneToMany(mappedBy = "parentEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ChildrenEntity> childrenEntity;
}
