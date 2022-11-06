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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private Double ticketPrice;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "bookingId")
    private List<Booking> bookingList;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="show_date_id")
    private ShowDate showDate;

    @OneToOne
    @JoinColumn(name = "roomId")
    private Room room;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="show_time_id")
    private ShowTime showTime;

    public Ticket(Integer ticketId) {
        this.ticketId = ticketId;
    }
}
