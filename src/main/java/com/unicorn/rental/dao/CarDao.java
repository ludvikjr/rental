package com.unicorn.rental.dao;

import com.unicorn.rental.model.car.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao extends CrudRepository<Car, Integer> {

//    @Query("SELECT car.id, car.mileage, car_model.name, brand.name FROM car JOIN car_model ON car_model.id=car.modelId JOIN brand ON brand.id=car_model.brandId")
//    public List<Car> fetchCarList();
}
