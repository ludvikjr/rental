package com.unicorn.rental.controller;

import com.unicorn.rental.domain.dto.CarDto;
import com.unicorn.rental.domain.model.car.Car;
import com.unicorn.rental.domain.requestTypes.CarRequestType;
import com.unicorn.rental.domain.responseTypes.Message;
import com.unicorn.rental.service.car.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable("id") int id) {
        CarDto carDto = carService.getCarById(id);

        if (carDto == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(carDto);
    }

    @PostMapping
    public ResponseEntity<Message> createCar(@RequestBody CarRequestType car) {

        if (car == null) return ResponseEntity.badRequest().build();

        try {
            Car savedCar = carService.createCar(car);

            if (savedCar == null) return ResponseEntity.badRequest().build();

            return ResponseEntity.ok(new Message("Car created successfully!"));
        } catch (Exception e) {

            System.out.println("Exception has occured: " + e);

            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deleteCarById(@PathVariable int id) {
        carService.deleteCarById(id);
        return ResponseEntity.ok(new Message("Car deleted successfully!"));
    }

}
