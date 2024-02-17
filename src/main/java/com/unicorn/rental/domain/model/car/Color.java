package com.unicorn.rental.domain.model.car;

import jakarta.persistence.*;

@Entity
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id")
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    // Constructors
    public Color() {
    }

    public Color(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
