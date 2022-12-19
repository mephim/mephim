package com.example.mephim.controller;

import com.example.mephim.request.TicketCreateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {
    @PostMapping("/create-new")
    public ResponseEntity<?> createNewTicket(@RequestBody TicketCreateDto ticketCreateDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
