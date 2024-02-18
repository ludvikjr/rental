package com.unicorn.rental.service.user;

import com.unicorn.rental.dao.user.CityDao;
import com.unicorn.rental.domain.model.user.City;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    private final CityDao cityDao;

    @Autowired
    public CityService(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    City findCityById(int id) {
        return cityDao.findById(id).orElse(null);
    }
}
