package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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


    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
