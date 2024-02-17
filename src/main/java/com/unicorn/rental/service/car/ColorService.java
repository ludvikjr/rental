package com.unicorn.rental.service.car;

import com.unicorn.rental.dao.car.ColorDao;
import com.unicorn.rental.domain.model.car.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColorService {

    private final ColorDao colorDao;

    @Autowired
    public ColorService(ColorDao colorDao) {
        this.colorDao = colorDao;
    }

    public Color findColorById(int id) {
        Optional<Color> color = colorDao.findById(id);
        return color.orElse(null);
    }

}
