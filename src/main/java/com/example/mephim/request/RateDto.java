package com.example.mephim.request;

import lombok.Data;

@Data
public class RateDto {
    private String username;
    private Integer movieId;
    private Double numRate;
    private String content;
}
