package com.example.demo.dto;

public class Hotel_Register_Request {
    private int fullDayFee;
    private int nightFee;
    private int numberOfRooms;
    private String address;
    private String hotelName;

    // Getters and Setters
    public int getFullDayFee() {
        return fullDayFee;
    }

    public void setFullDayFee(int fullDayFee) {
        this.fullDayFee = fullDayFee;
    }

    public int getNightFee() {
        return nightFee;
    }

    public void setNightFee(int nightFee) {
        this.nightFee = nightFee;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}