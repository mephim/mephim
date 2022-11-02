package com.example.mephim;

import com.example.mephim.constants.Constants;
import com.example.mephim.entity.*;
import com.example.mephim.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class MephimApplication {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(MephimApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return  args -> {
            System.out.println(bCryptPasswordEncoder.encode("123456"));
        };
    }
//    @Bean
    CommandLineRunner run(CommonService seatService) {
        return args -> {
            Arrays.asList(Constants.SEAT_ROW_LIST).forEach((item) -> {
                seatService.initialSeatRow(new SeatRow(item));
            });

            Arrays.asList(Constants.SEAT_COLUMN_LIST).forEach((item) -> {
                seatService.initialSeatColumn(new SeatColumn(item));
            });

            Arrays.asList(Constants.SEAT_TYPE_LIST).forEach((item) -> {
                seatService.initialSeatType(new SeatType(item));
            });

            Arrays.asList(Constants.SHOW_DATE_LIST).forEach((item) -> {
                seatService.initialShowDate(new ShowDate(item));
            });

            Arrays.asList(Constants.SHOW_TIME_LIST).forEach((item) -> {
                seatService.initialShowTime(new ShowTime(item));
            });

            Arrays.asList(Constants.CATEGORY_LIST).forEach((item) -> {
                seatService.initialCategory(new Category(item));
            });

            Arrays.asList(Constants.ACTOR_LIST).forEach((item) -> {
                seatService.initialActor(new Actor(item));
            });

            Arrays.asList(Constants.THEATER_GROUP_LIST).forEach((item) -> {
                seatService.initialTheaterGroup(new TheaterGroup(item));
            });
        };
    }

}
