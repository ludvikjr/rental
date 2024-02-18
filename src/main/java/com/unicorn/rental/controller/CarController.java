package com.unicorn.rental.controller;

import com.unicorn.rental.domain.dto.CarDto;
import com.unicorn.rental.domain.requestTypes.CarRequestType;
import com.unicorn.rental.domain.responseTypes.Message;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
import com.unicorn.rental.service.car.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car list has been sent to client."),
    })
    @Operation(summary = "List cars", description = "Lists all cars.")
    public ResponseEntity<List<CarDto>> listCars() {
        try {

            return ResponseEntity.ok(carService.listCars());

        } catch (Exception e) {

            System.out.println("An exception has occurred: " + e);
            return ResponseEntity.internalServerError().build();

        }
    }

    @GetMapping("{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car has been found and sent back to client.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarDto.class))),
            @ApiResponse(responseCode = "404", description = "Car has not been found.", content = @Content)
    })
    @Operation(summary = "Select car by id", description = "Select car by id. If it doesn't exist, API returns 404.")
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car has been created.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "400", description = "Required body parameters are either missing, or entities identified by these body parameters are non-existent.", content = @Content)
    })
    @Operation(summary = "Create car", description = "Create new car.")
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car has been deleted.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "404", description = "Car has not been found.", content = @Content)
    })
    @Operation(summary = "Delete car", description = "Deletes car based on id provided. If the car doesn't exist, 404 is sent by the API.")
    public ResponseEntity<Message> deleteCarById(@PathVariable int id) {
        try {

            carService.deleteCarById(id);
            return ResponseEntity.ok(new Message("Car deleted successfully!"));

        } catch (ItemNotFoundException e) {

            return ResponseEntity.notFound().build();

        } catch (Exception e) {

            System.out.println("An exception has occurred: " + e);
            return ResponseEntity.internalServerError().build();

        }
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car has been updated.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "404", description = "Car has not been found.", content = @Content)
    })
    @Operation(summary = "Update car", description = "Updates car based on id provided. If car is not found, API returns 404.")
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
