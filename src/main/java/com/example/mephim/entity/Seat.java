package com.example.mephim.entity;

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
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "seatRowId")
    private SeatRow seatRow;

    @ManyToOne
    @JoinColumn(name = "seatColumnId")
    private SeatColumn seatColumn;

    @ManyToOne
    @JoinColumn(name="seatTypeId")
    private SeatType seatType;

    @OneToMany(mappedBy = "roomSeatId")
    @JsonManagedReference
    private List<RoomSeat> roomSeats;
}
