package com.unicorn.rental.domain.model.car;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id")
    private int id;

    @Column(name = "registrationNumber")
    private String registrationNumber;

    @ManyToOne
    @JoinColumn(name = "colorId", referencedColumnName = "id", nullable = false)
    private Color color;

    @Column(name = "mileage")
    private int mileage;

    @ManyToOne
    @JoinColumn(name = "modelId", referencedColumnName = "id", nullable = false)
    private CarModel model;

    // Constructors
    public Car() {
    }

    public Car(int id, String registrationNumber, Color color, int mileage, CarModel carModel) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.mileage = mileage;
        this.model = carModel;
    }

    // Getters and setters
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel carModel) {
        this.model = carModel;
    }
}
