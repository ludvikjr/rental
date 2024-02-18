package com.unicorn.rental.mapper;

import com.unicorn.rental.domain.dto.CarRentalDto;
import com.unicorn.rental.domain.dto.UserDto;
import com.unicorn.rental.domain.model.user.CarRental;
import com.unicorn.rental.domain.model.user.User;
import com.unicorn.rental.service.user.AddressService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AddressService.class, CarMapper.class})
public interface UserMapper {



    CarRentalDto carRentalToRentalDto(CarRental carRental);
    List<CarRentalDto> carRentalToRentalDto(List<CarRental> carRental);

    @Mapping(source = "address.city.name", target = "address.city")
    @Mapping(source = "address.city.country", target = "address.country")
    @Mapping(source = "address.city.region", target = "address.region")
    @Mapping(source = "address.city.postalCode", target = "address.postalCode")
    UserDto userToUserDto(User user);

    List<UserDto> userListToUserDtoList(List<User> users);
}
