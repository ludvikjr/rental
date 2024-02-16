package com.unicorn.rental.mapper;

import com.unicorn.rental.dto.CarDto;
import com.unicorn.rental.car.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarMapper {

    @Mapping(source = "model.name", target = "model")
    @Mapping(source = "model.brand.name", target = "brand")
    @Mapping(source = "color.name", target = "color")
    CarDto carToCarDto(Car car);

    List<CarDto> carListToCarDtoList(List<Car> carList);
}
