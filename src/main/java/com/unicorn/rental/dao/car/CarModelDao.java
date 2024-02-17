package com.unicorn.rental.dao.car;

import com.unicorn.rental.domain.model.car.CarModel;
import org.springframework.data.repository.CrudRepository;

public interface CarModelDao extends CrudRepository<CarModel, Integer> {
}
