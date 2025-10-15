package com.learning.example.practice.springpracticesession3.DTO.OnetomanyPractice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParentPKDTO {

    @JsonProperty("parentId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonProperty("parentName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

}
