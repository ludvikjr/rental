package com.unicorn.rental.controller;

import com.unicorn.rental.domain.requestTypes.CarRentalRequestType;
import com.unicorn.rental.domain.responseTypes.Message;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
import com.unicorn.rental.service.carRental.CarRentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carRental")
public class CarRentalController {

    private final CarRentalService carRentalService;

    @Autowired
    public CarRentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car rental has been created.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "404", description = "Either user or car has not been found.", content = @Content),
            @ApiResponse(responseCode = "400", description = "User or car id is missing.", content = @Content)
    })
    @Operation(summary = "Create car rental", description = "Create new car rental.")
    public ResponseEntity<Message> createCarRental(@RequestBody CarRentalRequestType carRentalRequestType) {
        try {

            carRentalService.createCarRental(carRentalRequestType);

            return ResponseEntity.ok(new Message("Car rental has been created successfully!"));

        } catch (BodyMissingRequiredParamsException e) {

            return ResponseEntity.badRequest().build();

        } catch (ItemNotFoundException e) {

            return ResponseEntity.notFound().build();

        }
        catch (Exception e) {

            System.out.println("Error has occurred: " + e);
            return ResponseEntity.internalServerError().build();

        }
    }
}










