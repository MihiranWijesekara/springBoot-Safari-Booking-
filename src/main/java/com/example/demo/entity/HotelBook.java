package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel_book")
public class HotelBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String nicNumber;
    private String mobileNumber;
    private String bookingDate;
    private boolean fullDayFee;
    private boolean nightFee;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
