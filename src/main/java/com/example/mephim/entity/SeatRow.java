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
public class SeatRow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rowId;
    private String rowName;

    @OneToMany(mappedBy = "seatId")
    @JsonManagedReference
    private List<Seat> seats;

    public SeatRow(String rowName) {
        this.rowName = rowName;
    }
}
