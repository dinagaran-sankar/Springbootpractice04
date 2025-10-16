package com.learning.example.practice.springpracticesession3.DTO.LockMechanism;

import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SeatDTO {

    private String movieName;

    private Boolean isBooked;

    private Integer version;
}
