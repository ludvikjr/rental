package com.unicorn.rental.service.carRental;

import com.unicorn.rental.dao.car.CarDao;
import com.unicorn.rental.dao.carRental.CarRentalDao;
import com.unicorn.rental.dao.user.UserDao;
import com.unicorn.rental.domain.model.carRental.CarRental;
import com.unicorn.rental.domain.requestTypes.CarRentalRequestType;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
import com.unicorn.rental.mapper.CarRentalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarRentalService {

    private final CarRentalDao carRentalDao;
    private final CarDao carDao;
    private final UserDao userDao;


    private final CarRentalMapper carRentalMapper;

    @Autowired
    public CarRentalService(CarRentalDao carRentalDao, CarDao carDao, UserDao userDao, CarRentalMapper carRentalMapper) {
        this.carRentalDao = carRentalDao;
        this.carDao = carDao;
        this.userDao = userDao;
        this.carRentalMapper = carRentalMapper;
    }

    public CarRental createCarRental(CarRentalRequestType carRentalRequestType) {

        if (carRentalRequestType == null
                || carRentalRequestType.getUserId() == 0
                || carRentalRequestType.getCarId() == 0)
            throw new BodyMissingRequiredParamsException();

        CarRental carRental = carRentalMapper.carRentalRequestTypeToCarRental(carRentalRequestType);

        if (carDao.findById(carRental.getCar().getId()).isEmpty()
                || userDao.findById(carRental.getUser().getId()).isEmpty())
            throw new ItemNotFoundException();

        return carRentalDao.save(carRental);
    }
}
