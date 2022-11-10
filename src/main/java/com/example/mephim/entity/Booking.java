package com.example.mephim.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User user;

    private String time;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="booking_status_id")
    private BookingStatus BookingStatus;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "room_seat_id")
    @JsonBackReference
    private RoomSeat roomSeat;
}
