package com.example.mephim.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MovieTheater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieTheaterId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="theater_id")
    private Theater theater;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    public MovieTheater (Integer movieTheaterId) {
        this.movieTheaterId = movieTheaterId;
    }
}
