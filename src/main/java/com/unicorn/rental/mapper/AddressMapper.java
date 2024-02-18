package com.unicorn.rental.mapper;

import com.unicorn.rental.domain.model.user.Address;
import com.unicorn.rental.domain.requestTypes.AddressRequestType;
import com.unicorn.rental.service.user.CityService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CityService.class})
public interface AddressMapper {

    @Mapping(source = "cityId", target = "city.id")
    Address addressRequestTypeToAddress(AddressRequestType addressRequestType);
}
