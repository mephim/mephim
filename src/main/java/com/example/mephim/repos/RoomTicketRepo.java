package com.example.mephim.repos;

import com.example.mephim.entity.RoomTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTicketRepo extends JpaRepository<RoomTicket, Integer> {
}
