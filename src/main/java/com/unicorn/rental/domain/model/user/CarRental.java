package com.unicorn.rental.domain.model.user;

import com.unicorn.rental.domain.model.car.Car;
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
