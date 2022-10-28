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
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @OneToOne
    @JoinColumn(name="userId")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ticket_id")
    private Ticket ticket;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
