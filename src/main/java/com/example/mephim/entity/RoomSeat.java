package com.example.mephim.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JoinColumn(name="seatId")
    private Seat seat;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="roomId")
    private Room room;
}