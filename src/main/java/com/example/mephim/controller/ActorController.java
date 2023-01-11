package com.example.mephim.controller;

import com.example.mephim.entity.Actor;
import com.example.mephim.entity.Category;
import com.example.mephim.response.CustomResponse;
import com.example.mephim.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/actor")
@CrossOrigin("*")
public class ActorController {
    @Autowired
    ActorService actorService;

    @GetMapping("/list-actor")
    public ResponseEntity<?> listMovie() {
        List<Actor> actorList = actorService.findAll();
        if(actorList.isEmpty()) return new ResponseEntity<>(new CustomResponse<>(10, "data is empty"), HttpStatus.OK);
        return new ResponseEntity<>(new CustomResponse<>(10,actorList), HttpStatus.OK);
    }
}
