package com.unicorn.rental.dao.user;

import com.unicorn.rental.domain.model.user.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends CrudRepository<City, Integer> {
}
