package com.learning.example.practice.springpracticesession3.Entity.MappingRelations.LockMechanism;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="BookTickets")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SeatId",nullable = false)
    private Integer id;

    private String movieName;

    private Boolean isBooked;

    @Version
    private Integer version;
}
