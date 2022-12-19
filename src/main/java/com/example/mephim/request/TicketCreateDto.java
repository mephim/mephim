package com.example.mephim.request;

import lombok.Data;

@Data
public class TicketCreateDto {
    private Integer movieId;
    private Integer showDateId;
    private Integer showTimeId;
    private Integer roomId;
    private Long ticketPrice;
}
