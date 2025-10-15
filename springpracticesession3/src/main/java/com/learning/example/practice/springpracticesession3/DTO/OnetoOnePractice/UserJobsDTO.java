package com.learning.example.practice.springpracticesession3.DTO.OnetoOnePractice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserJobsDTO {

    @JsonProperty("UserName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonProperty("No.Of.Jobs")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numberOfJobs;
    @JsonProperty("UserContactNumber")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mobileNumber;

    private JobsDTO jobDTO;
}
