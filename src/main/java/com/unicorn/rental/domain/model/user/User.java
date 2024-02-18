package com.unicorn.rental.domain.model.user;

import com.unicorn.rental.domain.model.carRental.CarRental;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "fullName", nullable = false)
    String fullName;

    @OneToOne
    @JoinColumn(name = "addressId", referencedColumnName = "id", nullable = false)
    Address address;

    public User(String fullName, Address address) {
        this.fullName = fullName;
        this.address = address;
    }

    @OneToMany(mappedBy = "user")
    List<CarRental> rentals;
}
