package com.learning.example.practice.springpracticesession3.Service.LockMechanism;

import com.learning.example.practice.springpracticesession3.DTO.LockMechanism.SeatDTO;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.LockMechanism.Seat;

public interface SeatService {

    void createMovieTickets(SeatDTO seatDTO);

    SeatDTO fetchSeatDetails(Integer seatId);

    SeatDTO fetchSeatDetailsAndLock(Integer seatId);
}
