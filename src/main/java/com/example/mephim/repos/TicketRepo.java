package com.example.mephim.repos;

import com.example.mephim.entity.Ticket;
import com.example.mephim.response.ShowExistResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Query(value = "select ticket.* from ticket where ticket.movie_id = ?\n" +
            "and ticket.show_date_id = ?\n" +
            "and ticket.show_time_id = ?\n" +
            "and ticket.active = 1;", nativeQuery = true)
    Ticket findTicketByMovieIdAndShowDateIdAndShowTimeId(Integer movieId, Integer showDateId, Integer showTimeId);

    @Query(value = "select ticket.ticket_id, movie.movie_id, room.room_id, room.room_name, movie.movie_name, \n" +
            "STR_TO_DATE(concat(show_date.date,' ', show_time.time), '%Y-%m-%d %T') as time_start ,\n" +
            "STR_TO_DATE(concat(show_date.date,' ', show_time.time), '%Y-%m-%d %T') + INTERVAL movie.movie_length MINUTE as time_end \n" +
            "from ticket\n" +
            "inner join show_date inner join show_time inner join movie inner join room_ticket inner join room\n" +
            "where ticket.show_date_id = show_date.show_date_id\n" +
            "and ticket.show_time_id = show_time.show_time_id\n" +
            "and ticket.movie_id = movie.movie_id\n" +
            "and room_ticket.ticket_id = ticket.ticket_id\n" +
            "and room_ticket.room_id = room.room_id\n" +
            "having (time_start Between ?1 AND ?2\n" +
            "or time_end Between ?1 AND ?2);", nativeQuery = true)
    // Param timeStart and timeEnd must format like `2022-12-18 08:00`
    List<ShowExistResponse> findListShowExistByRoomAndTime(String timeStart, String timeEnd);
}
