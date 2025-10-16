package com.learning.example.practice.springpracticesession3.Repository.LockMechanism;

import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.LockMechanism.Seat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {

       @Lock(LockModeType.PESSIMISTIC_WRITE)
       @Query("select s from Seat s where s.id= :seatId")
       Seat findByIdAndLock(Integer seatId);
}
