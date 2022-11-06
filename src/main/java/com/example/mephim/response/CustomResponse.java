package com.example.mephim.response;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CustomResponse<T> {
    private String status;
    private String serverTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    private T data;
    public CustomResponse(String status) {
        this.status = status;
    }

    public CustomResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }
}
