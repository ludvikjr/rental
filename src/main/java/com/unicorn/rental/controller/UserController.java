package com.unicorn.rental.controller;

import com.unicorn.rental.domain.dto.UserDto;
import com.unicorn.rental.domain.requestTypes.UserRequestType;
import com.unicorn.rental.domain.responseTypes.Message;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
import com.unicorn.rental.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users are retrieved and sent back to client.")
    })
    @Operation(summary = "Get all users", description = "Get all users with their address and all of their previous car rentals.")
    public ResponseEntity<List<UserDto>> listUsers() {
        try {

            return ResponseEntity.ok(userService.listUsers());

        } catch (Exception e) {

            System.out.println("An exception has occurred: " + e);
            return ResponseEntity.internalServerError().build();

        }
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User has been created.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "404", description = "City has not been found.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Some required body values are missing.", content = @Content)
    })
    @Operation(summary = "Create user", description = "Create new user specified in request body.")
    public ResponseEntity<Message> createUser(@RequestBody UserRequestType userRequestType) {
        try {

            userService.createUser(userRequestType);

            return ResponseEntity.ok(new Message("User successfully created!"));

        } catch (BodyMissingRequiredParamsException e) {

            return ResponseEntity.badRequest().build();

        } catch (ItemNotFoundException e) {

            return ResponseEntity.notFound().build();

        } catch (Exception e) {

            System.out.println("An exception has occurred: " + e);
            return ResponseEntity.internalServerError().build();

        }
    }

}
