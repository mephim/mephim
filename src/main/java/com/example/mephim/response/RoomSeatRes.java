package com.example.mephim.response;

import lombok.Data;

@Data
public class RoomSeatRes implements Comparable<RoomSeatRes> {
    private Integer roomSeatId;
    private String seatName;
    private String seatType;
    private Boolean isBooking;

    @Override
    public int compareTo(RoomSeatRes o) {
        return this.roomSeatId - o.getRoomSeatId();
    }
}
