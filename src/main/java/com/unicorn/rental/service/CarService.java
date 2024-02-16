package com.unicorn.rental.service;

import com.unicorn.rental.dao.CarDao;
import com.unicorn.rental.dto.CarDto;
import com.unicorn.rental.mapper.CarMapper;
import com.unicorn.rental.model.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarDao carDao;
    private final CarMapper carMapper;

    @Autowired
    public CarService(CarMapper carMapper, CarDao carDao) {
        this.carDao = carDao;
        this.carMapper = carMapper;
    }

    public List<CarDto> listCars() {
        return carMapper.carListToCarDtoList((List<Car>)carDao.findAll());
    }
}
