package com.unicorn.rental.service.car;

import com.unicorn.rental.dao.car.BrandDao;
import com.unicorn.rental.domain.model.car.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService {

    private final BrandDao brandDao;

    @Autowired
    public BrandService(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    public Brand findBrandById(int id) {
        Optional<Brand> brand = brandDao.findById(id);
        return brand.orElse(null);
    }
}
