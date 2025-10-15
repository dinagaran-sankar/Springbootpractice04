package com.learning.example.practice.springpracticesession3.DTO.OnetomanyPractice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChildrenDTO {

    @JsonProperty("childName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonProperty("No.Of.Children")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer numberOfChildren;
}
