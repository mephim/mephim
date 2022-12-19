package com.example.mephim.response;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDateTime.now;

@Data
@SuperBuilder
public class CustomResponse<T> {
    private Integer code;
    private String status;
    private String serverTime = now().toString();
    private T data;
    public CustomResponse(String status) {
        this.status = status;
    }

    public CustomResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public CustomResponse(Integer code, String status, T data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }
}
