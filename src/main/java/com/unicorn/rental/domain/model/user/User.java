package com.unicorn.rental.domain.model.user;

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

    @Column(name = "fullName")
    String fullName;

    @OneToOne
    @JoinColumn(name = "addressId", referencedColumnName = "id")
    Address address;

//    @OneToMany
//    List<CarRental> rentals;
}
