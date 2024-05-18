package com.unicorn.rental.dao.car;

import com.unicorn.rental.domain.model.car.Color;
import org.springframework.data.repository.CrudRepository;

public interface ColorDao extends CrudRepository<Color, Integer> {
}
