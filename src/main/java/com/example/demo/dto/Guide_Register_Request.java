package com.example.demo.dto;

public class Guide_Register_Request {
    private int numberOfExperienceYears;
    private double hourlyRate;
    private String guideRegNumber;
    private int age;
    private String shortDescription;

    // Getters and Setters
    public int getNumberOfExperienceYears() {
        return numberOfExperienceYears;
    }

    public void setNumberOfExperienceYears(int numberOfExperienceYears) {
        this.numberOfExperienceYears = numberOfExperienceYears;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getGuideRegNumber() {
        return guideRegNumber;
    }

    public void setGuideRegNumber(String guideRegNumber) {
        this.guideRegNumber = guideRegNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
