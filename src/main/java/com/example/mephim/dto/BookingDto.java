package com.example.mephim.dto;

import lombok.Data;

@Data
public class BookingDto {
    private String user;
    private String time;
    private Integer ticketId;
    private Integer seatId;
    private Integer roomId;
    private Integer bookingStatusId;
}
