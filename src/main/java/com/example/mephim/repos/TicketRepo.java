package com.example.mephim.repos;

import com.example.mephim.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
    @Query(value = "select * from ticket where roomId = ?", nativeQuery = true)
    Ticket findTicketByRoomId(Integer roomId);

    @Query(value = "select * from ticket where movie_id = ?", nativeQuery = true)
    Ticket findTicketByMovie(Integer movieId);

    @Query(value = "select ticket.* from ticket inner join show_date inner join show_time\n" +
            "where ticket.show_date_id = show_date.show_date_id\n" +
            "and ticket.show_time_id = show_time.show_time_id\n" +
            "and ticket.show_date_id = ?\n" +
            "and ticket.show_time_id = ?;", nativeQuery = true)
    Ticket findTicketByShowDateAndShowTime(Integer showDateId, Integer showTimeId);
}
