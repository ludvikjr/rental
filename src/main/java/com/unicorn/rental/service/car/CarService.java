package com.unicorn.rental.service.car;

import com.unicorn.rental.dao.car.CarDao;
import com.unicorn.rental.domain.dto.CarDto;
import com.unicorn.rental.domain.requestTypes.CarRequestType;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
import com.unicorn.rental.helpers.utils.MyBeansUtil;
import com.unicorn.rental.mapper.CarMapper;
import com.unicorn.rental.domain.model.car.Car;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.Optional;

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

    public CarDto getCarById(int id) {
        Optional<Car> car = carDao.findById((id));

        if (car.isEmpty()) throw new ItemNotFoundException();

        return carMapper.carToCarDto(car.get());
    }

    public Car createCar(CarRequestType car) {

        Car mappedCar = carMapper.carRequestTypeToCar(car);

        if (mappedCar.getModel() == null || mappedCar.getColor() == null)
            throw new BodyMissingRequiredParamsException();

        return carDao.save(mappedCar);
    }

    public void deleteCarById(int id) {
        carDao.deleteById(id);
    }

    @Transactional
    public Car updateCar(CarRequestType carRequestType, int id) {

        Optional<Car> originalCar = carDao.findById(id);
        if (originalCar.isEmpty()) throw new ItemNotFoundException();
        Car retrievedCar = originalCar.get();

        Car updatedCar = carMapper.carRequestTypeToCar(carRequestType);

        MyBeansUtil<Car> beansUtil = new MyBeansUtil<>();

        return carDao.save(beansUtil.copyNonNullProperties(retrievedCar, updatedCar));
    }

}
