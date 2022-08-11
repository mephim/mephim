package com.example.mephim.entity;

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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private Double ticketPrice;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "ticketDetailId")
    private List<TicketDetail> ticketDetails;

    @ManyToOne
    @JoinColumn(name="show_date_id")
    private ShowDate showDate;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
}
