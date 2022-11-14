package com.example.mephim.response;

import com.example.mephim.entity.Movie;
import com.example.mephim.entity.ShowDate;
import com.example.mephim.entity.ShowTime;
import com.example.mephim.entity.Ticket;
import lombok.Data;

@Data
public class ShowTimeRes {
    private ShowDate showDateId;
    private ShowTime showTime;
    private TicketRes ticket;
    @Data
    public static class TicketRes {
        private Integer ticketId;
        private Long ticketPrice;
        private Movie movie;
    }
}
