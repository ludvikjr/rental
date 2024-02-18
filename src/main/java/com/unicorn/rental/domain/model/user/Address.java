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

    @Column(name = "street")
    String street;

    @Column(name = "building")
    int building;

    @ManyToOne
    @JoinColumn(name = "cityId", referencedColumnName = "id")
    City city;
}
