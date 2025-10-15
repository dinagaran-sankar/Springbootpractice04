package com.learning.example.practice.springpracticesession3.DTO.OnetoOnePractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobsPKDTO {

    @JsonProperty("JobsId")
    private Integer id;

    @JsonProperty("JobCompanyName")
    private String companyName;
}
