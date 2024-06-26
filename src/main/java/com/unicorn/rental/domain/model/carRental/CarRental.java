package com.unicorn.rental.domain.model.carRental;

import com.unicorn.rental.domain.model.car.Car;
import com.unicorn.rental.domain.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car_rental")
public class CarRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "rentedFrom")
    Date rentedFrom;

    @Column(name = "rentedTo")
    Date rentedTo;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "id", nullable = false)
    Car car;
}
