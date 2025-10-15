package com.learning.example.practice.springpracticesession3.DTO.OnetoOnePractice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class JobsDTO {

//    @JsonProperty("JobCompanyName")
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private String companyName;

    @JsonProperty("JobJoinDate")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "YYYY-MM-DD")
    private String joiningDate;


    @JsonProperty("JobSalary")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String salaryStructure;

    @JsonProperty("JobLeaves")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String employeeLeaves;

    @JsonProperty(value = "JobRegisterDate",access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateTime;

    private JobsPKDTO jobsPKDTO;
}
