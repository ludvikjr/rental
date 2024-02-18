package com.unicorn.rental.dao.carRental;

import com.unicorn.rental.domain.model.carRental.CarRental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRentalDao extends CrudRepository<CarRental, Integer> {
}
