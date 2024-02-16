package com.unicorn.rental.dto;


import java.io.Serializable;

public class CarDto implements Serializable {
    private int id;
    private String registrationNumber;
    private String color;
    private int mileage;
    private String model;
    private String brand;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public CarDto() {}

    public CarDto(int id, String registrationNumber, String color, int mileage, String model, String brand) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.mileage = mileage;
        this.model = model;
        this.brand = brand;
    }
}
