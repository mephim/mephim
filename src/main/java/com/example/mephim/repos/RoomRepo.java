package com.example.mephim.repos;

import com.example.mephim.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {
    @Query(value = "SELECT * FROM room WHERE room_seart.room_id = ?1", nativeQuery = true)
    Room findByRoomSeat(Integer roomSeat);
}
