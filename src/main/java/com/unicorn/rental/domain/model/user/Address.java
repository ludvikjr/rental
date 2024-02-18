package com.unicorn.rental.domain.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "street", nullable = false)
    String street;

    @Column(name = "building")
    Integer building;

    @ManyToOne
    @JoinColumn(name = "cityId", referencedColumnName = "id", nullable = false)
    City city;
}
