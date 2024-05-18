package com.unicorn.rental.mapper;

import com.unicorn.rental.domain.model.carRental.CarRental;
import com.unicorn.rental.domain.requestTypes.CarRentalRequestType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarRentalMapper {

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "carId", target = "car.id")
    CarRental carRentalRequestTypeToCarRental(CarRentalRequestType carRequestType);

}
