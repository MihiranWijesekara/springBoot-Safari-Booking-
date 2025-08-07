package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "guide_book")
public class GuideBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String nicNumber;
    private String mobileNumber;
    private String bookingDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
