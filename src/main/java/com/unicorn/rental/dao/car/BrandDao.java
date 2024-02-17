package com.unicorn.rental.dao.car;

import com.unicorn.rental.domain.model.car.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao extends CrudRepository<Brand, Integer> {
}

