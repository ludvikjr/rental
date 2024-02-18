package com.unicorn.rental.controller;

import com.unicorn.rental.domain.dto.UserDto;
import com.unicorn.rental.domain.responseTypes.Message;
import com.unicorn.rental.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Operation(summary = "Get all users", description = "Get all users with their address and all of their previous car rentals.")
    public ResponseEntity<List<UserDto>> listUsers() {
        try {

            return ResponseEntity.ok(userService.listUsers());

        } catch (Exception e) {

            System.out.println("An exception has occurred: " + e);
            return ResponseEntity.internalServerError().build();

        }
    }

}
