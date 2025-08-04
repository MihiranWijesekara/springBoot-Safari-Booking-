package com.example.demo.dto;

public class Vehicle_Register_Request {
    private String vehicleRegNumber;
    private double hourlyRate;
    private double fullDayServiceRate;
    private String vehicleType;
    private int numberOfTourists;

    // Getters
    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getFullDayServiceRate() {
        return fullDayServiceRate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getNumberOfTourists() {
        return numberOfTourists;
    }

    // Setters
    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setFullDayServiceRate(double fullDayServiceRate) {
        this.fullDayServiceRate = fullDayServiceRate;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setNumberOfTourists(int numberOfTourists) {
        this.numberOfTourists = numberOfTourists;
    }
}
