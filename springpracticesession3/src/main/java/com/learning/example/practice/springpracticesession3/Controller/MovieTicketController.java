package com.learning.example.practice.springpracticesession3.Controller;

import com.learning.example.practice.springpracticesession3.DTO.LockMechanism.SeatDTO;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.LockMechanism.Seat;
import com.learning.example.practice.springpracticesession3.Service.LockMechanism.SeatService;
import com.learning.example.practice.springpracticesession3.Service.LockMechanism.impl.OptimissiticLockMechanism;
import com.learning.example.practice.springpracticesession3.Service.LockMechanism.impl.PessimisticLockMechanism;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bookTickets")
@RequiredArgsConstructor
public class MovieTicketController {

    private final SeatService seatService;

    private final OptimissiticLockMechanism optimissiticLockMechanism;

    private final PessimisticLockMechanism pessimisticLockMechanism;

    @PostMapping("/createMovieTicket")
    public ResponseEntity<String> createMovieTicket(@RequestBody SeatDTO seatDTO)
    {
        seatService.createMovieTickets(seatDTO);

        return ResponseEntity.ok().body("The enter movie ticket successfully created");
    }

    @GetMapping("/fetchMovieTicketDetails/{id}")
    public ResponseEntity<String> fetchMovieTicketdetails(@PathVariable Integer id) throws InterruptedException {

        optimissiticLockMechanism.optimisticBookSeat(id);

        return  ResponseEntity.ok().body("fetch and update the movie ticket updated ");
    }
    @GetMapping("/fetchMovieTicketLock/{id}")
    public ResponseEntity<String> fetchMovieTicketdetailsWithLock(@PathVariable Integer id) throws InterruptedException {

        pessimisticLockMechanism.pessimisticBookSeatWithLock(id);

        return  ResponseEntity.ok().body("fetch and update the movie ticket updated with lock ");
    }

}
