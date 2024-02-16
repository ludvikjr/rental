package com.unicorn.rental.controller;

import com.unicorn.rental.dto.CarDto;
import com.unicorn.rental.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;
                                                                   
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDto> listCars() {
        return carService.listCars();
    }
}
