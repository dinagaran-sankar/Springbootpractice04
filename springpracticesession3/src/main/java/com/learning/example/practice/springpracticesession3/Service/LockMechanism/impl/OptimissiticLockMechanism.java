package com.learning.example.practice.springpracticesession3.Service.LockMechanism.impl;

import com.learning.example.practice.springpracticesession3.DTO.LockMechanism.SeatDTO;
import com.learning.example.practice.springpracticesession3.Service.LockMechanism.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptimissiticLockMechanism {

    private final SeatService seatService;

    public void optimisticBookSeat(Integer seatId) throws InterruptedException {
        Thread t = new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()  + " is attempting to book a seat ");
                SeatDTO seatDTO = seatService.fetchSeatDetails(seatId);
                System.out.println(Thread.currentThread().getName()  +" Thread A get a chance to get update seat id : "
                        + seatDTO.getVersion());
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName()  +" Thread A failed to book  a ticket : "
                        + e.getMessage());
            }
        });

        Thread t1 = new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()  + " is attempting to book a seat ");
                SeatDTO seatDTO = seatService.fetchSeatDetails(seatId);
                System.out.println(Thread.currentThread().getName()  +" Thread B get a chance to get update seat id : "
                        + seatDTO.getVersion());
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName()  +" Thread B failed to book  a ticket : "
                        + e.getMessage());
            }
        });

        t.start();
        t1.start();

        t.join();
        t1.join();

    }
}
