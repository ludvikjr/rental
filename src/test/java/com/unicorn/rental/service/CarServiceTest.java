package com.unicorn.rental.service;

import com.unicorn.rental.domain.dto.CarDto;
import com.unicorn.rental.domain.model.car.Car;
import com.unicorn.rental.domain.requestTypes.CarRequestType;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
import com.unicorn.rental.service.car.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    public void findCarByIdSuccessful() {
        assertDoesNotThrow(() -> carService.getCarById(1));

        CarDto car = carService.getCarById(1);

        assertEquals(car.getModel(), "a5");
        assertEquals(car.getBrand(), "Audi");
        assertEquals(car.getMileage(), 150000);
        assertEquals(car.getRegistrationNumber(), "ABC1234");
    }

    @Test
    public void findCarByIdFailed() {
        assertThrows(ItemNotFoundException.class, () -> carService.getCarById(69));
    }

    @Test
    public void carSaveAndRetrieveSuccessful() {
        CarRequestType newCarRequest = CarRequestType.builder()
                .colorId(1)
                .modelId(1)
                .mileage(123123)
                .registrationNumber("asdasd")
                .build();

        Car savedCar = carService.createCar(newCarRequest);

        assertEquals(savedCar.getModel().getBrand().getName(), "BMW");
        assertEquals(savedCar.getModel().getName(), "e39");
        assertEquals(savedCar.getColor().getName(), "Red");
        assertEquals(savedCar.getMileage(), 123123);
        assertEquals(savedCar.getRegistrationNumber(), "asdasd");
    }

    @Test
    public void carSaveFailedColorIdMissing() {
        CarRequestType newCarRequest = CarRequestType.builder()
                .modelId(1)
                .mileage(123123)
                .registrationNumber("asdasd")
                .build();

        assertThrows(BodyMissingRequiredParamsException.class, () -> carService.createCar(newCarRequest));
    }

    @Test
    public void carSaveFailedModelIdMissing() {
        CarRequestType newCarRequest = CarRequestType.builder()
                .colorId(1)
                .mileage(123123)
                .registrationNumber("asdasd")
                .build();

        assertThrows(BodyMissingRequiredParamsException.class, () -> carService.createCar(newCarRequest));
    }

    @Test
    public void carDeleteSuccessful() {
        CarRequestType newCarRequest = CarRequestType.builder()
                .colorId(1)
                .modelId(1)
                .mileage(123123)
                .registrationNumber("asdasd")
                .build();

        Car savedCar = carService.createCar(newCarRequest);

        carService.deleteCarById(savedCar.getId());

        assertThrows(ItemNotFoundException.class, () -> carService.getCarById(savedCar.getId()));
    }

    @Test
    public void carUpdateSuccessful() {
        CarRequestType newCarRequest = CarRequestType.builder()
                .colorId(1)
                .modelId(1)
                .mileage(123123)
                .registrationNumber("asdasd")
                .build();

        Car savedCar = carService.createCar(newCarRequest);

        CarRequestType updateCarRequest = CarRequestType.builder()
                .colorId(2)
                .modelId(2)
                .mileage(33333)
                .build();

        Car updatedCar = carService.updateCar(updateCarRequest, savedCar.getId());

        System.out.println(carService.getCarById(savedCar.getId()).toString());

        assertEquals(updatedCar.getModel().getName(), "e46");
        assertEquals(updatedCar.getColor().getName(), "Blue");
        assertEquals(updatedCar.getMileage(), 33333);
        assertEquals(updatedCar.getRegistrationNumber(), "asdasd");
    }

    @Test
    public void carUpdateFailed() {
        CarRequestType updateCarRequest = CarRequestType.builder()
                .colorId(1)
                .modelId(1)
                .mileage(123123)
                .registrationNumber("asdasd")
                .build();

        assertThrows(ItemNotFoundException.class, () -> carService.updateCar(updateCarRequest, 6969));
    }



}
