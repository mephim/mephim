package com.example.mephim.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @JoinColumn(name="seatId")
    private Seat seat;

}
