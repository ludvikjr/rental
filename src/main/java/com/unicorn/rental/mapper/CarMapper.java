package com.unicorn.rental.mapper;

import com.unicorn.rental.domain.dto.CarDto;
import com.unicorn.rental.domain.model.car.Car;
import com.unicorn.rental.domain.requestTypes.CarRequestType;
import com.unicorn.rental.service.car.CarModelService;
import com.unicorn.rental.service.car.ColorService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ColorService.class, CarModelService.class})
public interface CarMapper {

    @Mapping(source = "model.name", target = "model")
    @Mapping(source = "model.brand.name", target = "brand")
    @Mapping(source = "color.name", target = "color")
    CarDto carToCarDto(Car car);

    @Mapping(source = "modelId", target = "model")
    @Mapping(source = "colorId", target = "color")
    Car carRequestTypeToCar(CarRequestType carRequestType);

    List<CarDto> carListToCarDtoList(List<Car> carList);
}
