package com.example.mephim.response;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CustomResponse {
    private String status;
    private String serverTime;
    public CustomResponse(String status) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.status = status;
        this.serverTime = dtf.format(LocalDateTime.now());
    }
}
