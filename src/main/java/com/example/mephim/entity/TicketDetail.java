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
public class TicketDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketDetailId;

    @ManyToOne
    @JoinColumn(name="ticketId")
    private Ticket ticket;

    @OneToOne
    @JoinColumn(name="room_id")
    private Room room;

    @OneToMany(mappedBy = "bookingId")
    @JsonManagedReference
    private List<Booking> bookings;
}
