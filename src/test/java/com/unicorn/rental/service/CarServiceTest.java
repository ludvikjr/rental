package com.unicorn.rental.service;

import com.unicorn.rental.dao.car.CarDao;
import com.unicorn.rental.domain.dto.CarDto;
import com.unicorn.rental.domain.model.car.Brand;
import com.unicorn.rental.domain.model.car.Car;
import com.unicorn.rental.domain.model.car.CarModel;
import com.unicorn.rental.domain.model.car.Color;
import com.unicorn.rental.domain.requestTypes.CarRequestType;
import com.unicorn.rental.service.car.BrandService;
import com.unicorn.rental.service.car.CarModelService;
import com.unicorn.rental.service.car.CarService;
import com.unicorn.rental.service.car.ColorService;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
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
    private CarModelService carModelService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private CarDao carDao;

    @Autowired
    private CarService carService;


    @AfterEach
    public void tearDown() {
        carDao.deleteById(2);
    }

    @Test
    public void findCarByIdSuccessful() {
        CarDto car = carService.getCarById(1);

        assertNotNull(car);
        assertEquals(car.getModel(), "a5");
        assertEquals(car.getBrand(), "Audi");
        assertEquals(car.getMileage(), 150000);
        assertEquals(car.getRegistrationNumber(), "ABC1234");
    }

    @Test
    public void findCarByIdFailed() {
        CarDto car = carService.getCarById(69);

        assertNull(car);
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

        assertNotNull(savedCar);

        CarModel carModel = carModelService.findCarModelById(1);
        Color color = colorService.findColorById(1);
        Brand brand = brandService.findBrandById(1);


        assertEquals(savedCar.getModel().getBrand().getName(), brand.getName());
        assertEquals(savedCar.getModel().getName(), carModel.getName());
        assertEquals(savedCar.getColor().getName(), color.getName());
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

        assertNull(carService.createCar(newCarRequest));
    }

    @Test
    public void carSaveFailedModelIdMissing() {
        CarRequestType newCarRequest = CarRequestType.builder()
                .colorId(1)
                .mileage(123123)
                .registrationNumber("asdasd")
                .build();

        assertNull(carService.createCar(newCarRequest));
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

        assertNull(carService.getCarById(savedCar.getId()));
    }

}
