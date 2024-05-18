package com.unicorn.rental.dao.car;

import com.unicorn.rental.domain.model.car.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends CrudRepository<Car, Integer> {
}
