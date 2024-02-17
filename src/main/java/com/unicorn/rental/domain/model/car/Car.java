package com.unicorn.rental.domain.model.car;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
