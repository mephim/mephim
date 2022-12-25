package com.example.mephim.request;

import lombok.Data;

@Data
public class BookingDto {
    private String user;
    private Integer seatId;
    private Integer ticketId;
}
