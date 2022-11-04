package com.example.mephim.response;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CustomResponse<T> {
    private String status;
    private String serverTime;
    private T data;
    public CustomResponse(String status) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.status = status;
        this.serverTime = dtf.format(LocalDateTime.now());
    }

    public CustomResponse(String status, T data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.status = status;
        this.serverTime = dtf.format(LocalDateTime.now());
        this.data = data;
    }
}
