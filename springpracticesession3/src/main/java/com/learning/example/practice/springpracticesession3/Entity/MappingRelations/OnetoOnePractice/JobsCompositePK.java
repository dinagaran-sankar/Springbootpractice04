package com.learning.example.practice.springpracticesession3.Entity.MappingRelations.OnetoOnePractice;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Setter
@Getter
public class JobsCompositePK implements Serializable {

    @Column(name="JobsId")
    private Integer id;

    @Column(name="JobCompanyName")
    private String companyName;
}
