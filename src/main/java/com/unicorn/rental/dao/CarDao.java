package com.unicorn.rental.dao;

import com.unicorn.rental.car.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends CrudRepository<Car, Integer> {
}
