package com.example.mephim.request;

import lombok.Data;

@Data
public class BookingDto {
    private String user;
    private Integer ticketId;
    private Integer seatRowId;
    private Integer seatColumnId;
    private Integer seatTypeId;
    private Integer roomId;
}
