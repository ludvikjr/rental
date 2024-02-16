package com.unicorn.rental.controller;

import com.unicorn.rental.dto.CarDto;
import com.unicorn.rental.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    private final CarService carService;
                                                                   
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<CarDto> listCars() {
        return carService.listCars();
    }

    @GetMapping("car/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable("id") int id) {
        CarDto carDto = carService.getCarById(id);

        if (carDto == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(carDto);
    }

}
