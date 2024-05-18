package com.unicorn.rental.service;

import com.unicorn.rental.domain.requestTypes.CarRentalRequestType;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
import com.unicorn.rental.service.carRental.CarRentalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class CarRentalServiceTest {

    @Autowired
    private CarRentalService carRentalService;

    @Test
    public void createCarRentalSuccessful() {

        CarRentalRequestType carRentalRequestType = CarRentalRequestType.builder()
                .carId(1)
                .userId(1)
                .rentedFrom(new Date())
                .rentedTo(new Date())
                .build();

        assertDoesNotThrow(() -> carRentalService.createCarRental(carRentalRequestType));
    }

    @Test
    public void createCarRentalCarIdMissing() {
        CarRentalRequestType carRentalRequestType = CarRentalRequestType.builder()
                .userId(1)
                .rentedFrom(new Date())
                .rentedTo(new Date())
                .build();

        assertThrows(BodyMissingRequiredParamsException.class, () -> carRentalService.createCarRental(carRentalRequestType));
    }

    @Test
    public void createCarRentalUserIdMissing() {
        CarRentalRequestType carRentalRequestType = CarRentalRequestType.builder()
                .carId(1)
                .rentedFrom(new Date())
                .rentedTo(new Date())
                .build();

        assertThrows(BodyMissingRequiredParamsException.class, () -> carRentalService.createCarRental(carRentalRequestType));
    }

    @Test
    public void createCarRentalNonexistentCarId() {
        CarRentalRequestType carRentalRequestType = CarRentalRequestType.builder()
                .userId(1)
                .carId(99)
                .rentedFrom(new Date())
                .rentedTo(new Date())
                .build();

        assertThrows(ItemNotFoundException.class, () -> carRentalService.createCarRental(carRentalRequestType));
    }

    @Test
    public void createCarRentalNonexistentUserId() {
        CarRentalRequestType carRentalRequestType = CarRentalRequestType.builder()
                .userId(99)
                .carId(1)
                .rentedFrom(new Date())
                .rentedTo(new Date())
                .build();

        assertThrows(ItemNotFoundException.class, () -> carRentalService.createCarRental(carRentalRequestType));
    }

}
