package com.example.mephim.controller;

import com.example.mephim.constants.Constants;
import com.example.mephim.constants.ERROR_CODE;
import com.example.mephim.entity.Booking;
import com.example.mephim.exception.ShowConflictBySameMovieInTimeException;
import com.example.mephim.exception.ShowConflictBySameRoomException;
import com.example.mephim.request.TicketCreateDto;
import com.example.mephim.response.CustomResponse;
import com.example.mephim.service.TicketService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/create-new")
    public ResponseEntity<?> createNewTicket(@RequestBody TicketCreateDto ticketCreateDto) {
        Object result;
        try {
            result = ticketService.save(ticketCreateDto);
        } catch (ShowConflictBySameMovieInTimeException  e) {
            JSONObject dataResponseJson=new JSONObject();
            dataResponseJson.put("conflictTicket", e.getData());
            return new ResponseEntity<>(new CustomResponse<>(ERROR_CODE.CONFLICT_MOVIE ,e.getMessage(),dataResponseJson), HttpStatus.EXPECTATION_FAILED);
        } catch (ShowConflictBySameRoomException e) {
            JSONObject dataResponseJson=new JSONObject();
            dataResponseJson.put("conflictTicket", e.getData());
            return new ResponseEntity<>(new CustomResponse<>(ERROR_CODE.CONFLICT_ROOM,e.getMessage(),dataResponseJson), HttpStatus.EXPECTATION_FAILED);
        }

        JSONObject dataResponseJson=new JSONObject();
        dataResponseJson.put("ticket", result);
        return new ResponseEntity<>(new CustomResponse<>(Constants.RESPONSE_STATUS_SUCCESS,dataResponseJson), HttpStatus.CREATED);
    }
}
