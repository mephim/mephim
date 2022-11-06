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
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;
    private String theaterName;
    private String theaterAddress;
    private String theaterDescription;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="theater_group_id")
    private TheaterGroup theaterGroup;

//    @OneToMany(mappedBy = "movieTheaterId")
//    @JsonManagedReference
//    private List<MovieTheater> movieTheatersList;
}
