package com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetomanyPractice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "childRelation")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChildrenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "childId",nullable = false)
    private Integer id;
    @Column(name = "childName",nullable = false)
    private String name;
    @Column(name = "No.Of.Children",nullable = false)
    private Integer numberOfChildren;

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name = "parentId", referencedColumnName = "parentId"),
            @JoinColumn(name = "parentName", referencedColumnName = "parentName")
    })
    private ParentEntity parentEntity;
}
