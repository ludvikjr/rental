package com.unicorn.rental.controller;

import com.unicorn.rental.domain.dto.CarDto;
import com.unicorn.rental.domain.requestTypes.CarRequestType;
import com.unicorn.rental.domain.responseTypes.Message;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
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
    public ResponseEntity<List<CarDto>> listCars() {
        try {

            return ResponseEntity.ok(carService.listCars());

        } catch (Exception e) {

            System.out.println("An exception has occurred: " + e);
            return ResponseEntity.internalServerError().build();

        }
    }

    @GetMapping("{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable("id") int id) {
        try {

            CarDto carDto = carService.getCarById(id);
            return ResponseEntity.ok(carDto);

        } catch (ItemNotFoundException e) {

            return ResponseEntity.notFound().build();

        } catch (Exception e) {

            System.out.println("An exception has occurred: " + e);
            return ResponseEntity.internalServerError().build();

        }
    }

    @PostMapping
    public ResponseEntity<Message> createCar(@RequestBody CarRequestType car) {
        try {

            if (car == null) return ResponseEntity.badRequest().build();
            carService.createCar(car);
            return ResponseEntity.ok(new Message("Car created successfully!"));

        } catch (BodyMissingRequiredParamsException e) {

            return ResponseEntity.badRequest().build();

        } catch (Exception e) {

            System.out.println("An exception has occurred: " + e);
            return ResponseEntity.internalServerError().build();

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deleteCarById(@PathVariable int id) {
        try {

            carService.deleteCarById(id);
            return ResponseEntity.ok(new Message("Car deleted successfully!"));

        } catch (Exception e) {

            System.out.println("An exception has occurred: " + e);
            return ResponseEntity.internalServerError().build();

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateCarById(@PathVariable int id, @RequestBody CarRequestType carRequestType) {
        try {

            carService.updateCar(carRequestType, id);
            return ResponseEntity.ok(new Message("Car successfully updated!"));

        } catch (ItemNotFoundException e) {

            return ResponseEntity.notFound().build();

        } catch (Exception e) {

            System.out.println("An exception has occurred: " + e);
            return ResponseEntity.internalServerError().build();

        }
    }

}
