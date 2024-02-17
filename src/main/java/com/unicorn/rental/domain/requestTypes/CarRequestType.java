package com.unicorn.rental.domain.requestTypes;

public class CarRequestType {
    private String registrationNumber;
    private int colorId;
    private int mileage;
    private int modelId;

    // Constructors, toString
    public CarRequestType() {}

    public CarRequestType(String registrationNumber, int colorId, int mileage, int modelId, int brandId) {
        this.registrationNumber = registrationNumber;
        this.colorId = colorId;
        this.mileage = mileage;
        this.modelId = modelId;
    }

    // Getter and setters

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }
}
