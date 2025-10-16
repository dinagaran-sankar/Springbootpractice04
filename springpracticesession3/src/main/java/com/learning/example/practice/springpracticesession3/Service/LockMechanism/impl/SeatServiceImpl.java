package com.learning.example.practice.springpracticesession3.Service.LockMechanism.impl;

import com.learning.example.practice.springpracticesession3.DTO.LockMechanism.SeatDTO;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.LockMechanism.Seat;
import com.learning.example.practice.springpracticesession3.Repository.LockMechanism.SeatRepository;
import com.learning.example.practice.springpracticesession3.Service.LockMechanism.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    @Transactional
    @Override
    public void createMovieTickets(SeatDTO seatDTO)
    {
        System.out.println("create movie ticket starting");
         Seat seat = new Seat();
         seat.setMovieName(seatDTO.getMovieName());
         seat.setIsBooked(seatDTO.getIsBooked());
         seatRepository.save(seat);
         System.out.println("create movie ticket ending");
    }

    @Transactional
    @Override
    public SeatDTO fetchSeatDetails(Integer seatId) {

        Optional<Seat> byId = seatRepository.findById(seatId);

        System.out.println(Thread.currentThread().getName() + " fetch seat with version " + byId.get().getVersion());

        if (byId.get().getIsBooked())
        {
            throw new RuntimeException("Movie ticket already booked");
        }

        byId.get().setIsBooked(true);

        Seat save = seatRepository.save(byId.get());
        SeatDTO seatDTO = new SeatDTO(save.getMovieName(),save.getIsBooked(),save.getVersion());
        return seatDTO;
    }


    @Transactional
    @Override
    public SeatDTO fetchSeatDetailsAndLock(Integer seatId) {

        System.out.println(Thread.currentThread().getName() + " is attempting to acquire the lock ");

        Seat byIdAndLock = seatRepository.findByIdAndLock(seatId);

        System.out.println(Thread.currentThread().getName() + " seatid is acquiring the lock " + seatId);

        if (byIdAndLock.getIsBooked())
        {
            System.out.println(Thread.currentThread().getName() + " failed to book seat id and already booked " + seatId);
            throw new RuntimeException("Movie ticket already booked");
        }

        System.out.println(Thread.currentThread().getName() + " after successfully booked the seat " + seatId);

        byIdAndLock.setIsBooked(true);

        Seat save = seatRepository.save(byIdAndLock);
        System.out.println(Thread.currentThread().getName() + " successfully booked the seat " + seatId);
        SeatDTO seatDTO = new SeatDTO(save.getMovieName(),save.getIsBooked(),save.getVersion());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return seatDTO;
    }


}
