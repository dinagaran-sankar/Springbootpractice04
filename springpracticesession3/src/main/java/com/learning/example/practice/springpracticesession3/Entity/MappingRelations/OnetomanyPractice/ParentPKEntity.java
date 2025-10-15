package com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetomanyPractice;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ParentPKEntity implements Serializable {

    @Column(name = "parentId",nullable = false)
    private Integer id;
    @Column(name = "parentName",nullable = false)
    private String name;


}
