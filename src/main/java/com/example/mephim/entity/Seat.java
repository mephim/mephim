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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="seatTypeId")
    private SeatType seatType;

    @OneToMany(mappedBy = "bookingId")
    @JsonManagedReference
    private List<Booking> bookingList;
}
