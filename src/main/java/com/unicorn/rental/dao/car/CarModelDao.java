package com.unicorn.rental.dao.car;

import com.unicorn.rental.domain.model.car.CarModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelDao extends CrudRepository<CarModel, Integer> {
}
