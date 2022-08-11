//package com.example.mephim.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class RoomSeat {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer roomSeatId;
//
//    @ManyToOne
//    @JoinColumn(name="seatId")
//    private Seat seat;
//
//    @ManyToOne
//    @JoinColumn(name="roomId")
//    private Room room;
//}
//package com.example.mephim.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class RoomSeat {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer roomSeatId;
//
//    @ManyToOne
//    @JoinColumn(name="seatId")
//    private Seat seat;
//
//    @ManyToOne
//    @JoinColumn(name="roomId")
//    private Room room;
//}
