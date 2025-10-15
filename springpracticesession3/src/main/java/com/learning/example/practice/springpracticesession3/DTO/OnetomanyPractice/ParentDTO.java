package com.learning.example.practice.springpracticesession3.DTO.OnetomanyPractice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ParentDTO {

//    @JsonProperty("parentName")
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private String name;

    @JsonProperty("parentContactNo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mobileNumber;

    @JsonProperty("parentAddress")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String address;

    private ParentPKDTO parentPKDTO;

    private List<ChildrenDTO> childrenDTO;
}
