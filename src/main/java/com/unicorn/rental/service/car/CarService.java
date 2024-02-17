package com.unicorn.rental.service.car;

import com.unicorn.rental.dao.car.CarDao;
import com.unicorn.rental.dao.car.CarModelDao;
import com.unicorn.rental.dao.car.ColorDao;
import com.unicorn.rental.domain.dto.CarDto;
import com.unicorn.rental.domain.requestTypes.CarRequestType;
import com.unicorn.rental.mapper.CarMapper;
import com.unicorn.rental.domain.model.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarDao carDao;
    private final ColorDao colorDao;
    private final CarModelDao carModelDao;
    private final CarMapper carMapper;

    @Autowired
    public CarService(CarMapper carMapper, CarDao carDao, CarModelDao carModelDao, ColorDao colorDao) {
        this.carDao = carDao;
        this.carModelDao = carModelDao;
        this.carMapper = carMapper;
        this.colorDao = colorDao;
    }

    public List<CarDto> listCars() {
        return carMapper.carListToCarDtoList((List<Car>)carDao.findAll());
    }

    public CarDto getCarById(int id) {
        Optional<Car> car = carDao.findById((id));
        return car.map(carMapper::carToCarDto).orElse(null);
    }

    public Car createCar(CarRequestType car) {

        Car mappedCar = carMapper.carRequestTypeToCar(car);

        if (mappedCar.getModel() == null || mappedCar.getColor() == null) return null;

        return carDao.save(mappedCar);
    }

    public void deleteCarById(int id) {
        carDao.deleteById(id);
    }
}
