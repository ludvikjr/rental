package com.unicorn.rental.service.car;

import com.unicorn.rental.dao.car.CarModelDao;
import com.unicorn.rental.domain.model.car.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarModelService {

    private final CarModelDao carModelDao;

    @Autowired
    public CarModelService(CarModelDao carModelDao) {
        this.carModelDao = carModelDao;
    }

    public CarModel findCarModelById(int id) {
        Optional<CarModel> carModel = carModelDao.findById(id);
        return carModel.orElse(null);
    }
}
