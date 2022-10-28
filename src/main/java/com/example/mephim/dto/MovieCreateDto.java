package com.example.mephim.dto;

import lombok.Data;

import java.util.List;

@Data
public class MovieCreateDto {
    private String movieName;
    private String movieDirector;
    private Integer movieLength;
    private String movieTrailerUrl;
    private String moviePoster;
    private String movieDescription;
    private List<Integer> movieCategoryIds;
    private List<Integer> movieActorIds;
    private List<Integer> movieTheaterIds;
}
