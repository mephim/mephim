package com.example.mephim.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomSeatId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="seat_id")
    private Seat seat;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="seat_type_id")
    private SeatType seatType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "bookingId")
    @JsonManagedReference
    private List<Booking> bookingList;

    public RoomSeat(Room room, Seat seat, SeatType seatType) {
        this.room = room;
        this.seat = seat;
        this.seatType = seatType;
    }

}
