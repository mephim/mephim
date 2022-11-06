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
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieActorId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="actor_id")
    private Actor actor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie_id")
    private Movie movie;

    public MovieActor (Integer movieActorId) {
        this.movieActorId = movieActorId;
    }
}
