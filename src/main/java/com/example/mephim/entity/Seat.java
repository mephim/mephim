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
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "seatRowId")
    private SeatRow seatRow;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "seatColumnId")
    private SeatColumn seatColumn;

    @OneToMany(mappedBy = "roomSeatId")
    @JsonManagedReference
    private List<RoomSeat> roomSeatList;

    public Seat(Integer seatId) {
        this.seatId = seatId;
    }

    public Seat(SeatRow seatRow, SeatColumn seatColumn) {
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
    }
}
