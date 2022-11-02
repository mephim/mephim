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
    private String movieDirector;
    private Integer movieLength;
    private String movieTrailerUrl;
    private String moviePoster;
    private String movieDescription;

//    @OneToMany(mappedBy = "movieCategoryId")
//    @JsonManagedReference
//    private List<MovieCategory> movieCategories;

//    @OneToMany(mappedBy = "movieActorId")
//    @JsonManagedReference
//    private List<MovieActor> movieActors;

//    @OneToMany(mappedBy = "movieTheaterId")
//    @JsonManagedReference
//    private List<MovieTheater> movieTheaters;

    public Movie(Integer movieId){
        this.movieId = movieId;
    }
}
