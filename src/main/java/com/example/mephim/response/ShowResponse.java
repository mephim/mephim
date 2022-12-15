package com.example.mephim.response;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

@Data
public class ShowResponse {
    private String date;
    private String time;
    private Integer movieLength;
    private String movieName;

    public ShowResponse(HashMap<?, ?> values) {
        this.date = (String) values.get(date);
        this.time  = (String) values.get(time);
        this.movieLength  = (Integer) values.get(movieLength);
        this.movieName  = (String) values.get(movieName);
    }
}