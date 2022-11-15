package com.example.mephim.response;

import com.example.mephim.entity.*;
import lombok.Data;

@Data
public class ShowTimeRes {
    private ShowDate showDateId;
    private ShowTime showTime;
    private TicketRes ticket;
    private Room room;
    @Data
    public static class TicketRes {
        private Integer ticketId;
        private Long ticketPrice;
        private Movie movie;
    }
}
