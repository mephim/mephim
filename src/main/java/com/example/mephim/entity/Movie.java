package com.example.mephim.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private String movieName;
    private String movieActor;
    private String movieDirector;
    private Integer movieLength;
    private String movieTrailerUrl;
    private String moviePoster;
    @Column(length=5000)
    private String movieDescription;
    public Movie(Integer movieId){
        this.movieId = movieId;
    }
}
